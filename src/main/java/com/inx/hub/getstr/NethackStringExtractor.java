package com.inx.hub.getstr;

import org.antlr.v4.runtime.ANTLRInputStream;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;

public class NethackStringExtractor {
    private static Path getStrFile(Path file) {
        String s = file.toString();
        int lastDot = s.lastIndexOf(".");
        return Paths.get(s.substring(0, lastDot) + ".str");
    }

    private static void extract(Path file) {
        System.out.println("[Extract]" + file);

        try {
            String content = new String(Files.readAllBytes(file), "UTF-8");
            ANTLRInputStream ais = new ANTLRInputStream(content);
            CLexer lexer = new CLexer(ais);
            TokenStream ts = new CommonTokenStream(lexer);
            CParser parser = new CParser(ts);

            
            //忽略错误
            lexer.getErrorListeners().clear();
            parser.getErrorListeners().clear();

            final StringBuilder sb = new StringBuilder();

            parser.addParseListener(new CBaseListener() {
                @Override
                public void exitPrimaryExpression(CParser.PrimaryExpressionContext ctx) {
                    List<TerminalNode> stringLiterals = ctx.StringLiteral();
                    if (stringLiterals.size() != 0) {
                        for (TerminalNode stringLiteral : stringLiterals) {
                            sb.append(stringLiteral.getSymbol().getLine() + "|" + stringLiteral.getSymbol().getStartIndex() + "|" +
                                    stringLiteral.getSymbol().getStopIndex()).append("\n");
                            sb.append(stringLiteral.getText()).append("\n");
                        }
                    }
                }
            });
            parser.compilationUnit();

            Files.write(getStrFile(file), sb.toString().getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        if (args.length < 1) {
            System.out.println("Usage: java -jar nethack_string_extractor-all.jar <nethack_src_dir>");
            return;
        }

        Path rootPath = Paths.get(args[0]);

        Files.walkFileTree(rootPath, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs)
                    throws IOException {
                if (file.toString().endsWith(".c")) {
                    extract(file);
                }

                return FileVisitResult.CONTINUE;
            }
        });
    }
}
