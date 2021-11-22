import 'package:dart_cli_tools/lexicon/lexicon.dart';
import 'package:dart_cli_tools/utils/string_util.dart';

class NameUtil {
  static String packageName(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 8), max: NOUN.length);
    var list = [NOUN[num]];
    num = StringUtil.hexToInt(md5.substring(8, 16), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(16, 24), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(24, 32), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    return list.join('.');
  }

  static String dirName(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 8), max: NOUN.length);
    var list = [NOUN[num]];
    num = StringUtil.hexToInt(md5.substring(8, 16), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(16, 24), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(24, 32), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    return list.join('/');
  }

  static String ClassName(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 8), max: ADJECTIVE.length);
    var list = [StringUtil.firstUpperCase(ADJECTIVE[num])];
    num = StringUtil.hexToInt(md5.substring(8, 16), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(StringUtil.firstUpperCase(NOUN[num]));
    num = StringUtil.hexToInt(md5.substring(16, 24), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(StringUtil.firstUpperCase(ADJECTIVE[num]));
    num = StringUtil.hexToInt(md5.substring(24, 32), max: NOUN.length);
    return (list..add(StringUtil.firstUpperCase(NOUN[num]))).join();
  }

  static String class_name(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 8), max: ADJECTIVE.length);
    var list = [ADJECTIVE[num]];
    num = StringUtil.hexToInt(md5.substring(8, 16), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(16, 24), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(ADJECTIVE[num]);
    num = StringUtil.hexToInt(md5.substring(24, 32), max: NOUN.length);
    return (list..add(NOUN[num])).join('_');
  }

  static String objectName(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 16), max: ADJECTIVE.length * 2);
    var _adjective;
    if (num < ADJECTIVE.length) {
      _adjective = ADJECTIVE[num];
    }
    num = StringUtil.hexToInt(md5.substring(16, 32), max: NOUN.length);
    if (_adjective == null) {
      return NOUN[num];
    } else {
      return '$_adjective${StringUtil.firstUpperCase(NOUN[num])}';
    }
  }

  static String noun(String md5) {
    return NOUN[StringUtil.hexToInt(md5.substring(0, 32), max: NOUN.length)];
  }

  static String methodName(String md5) {
    var _verb = VERB[StringUtil.hexToInt(md5.substring(0, 11), max: VERB.length)];
    var _adjective = StringUtil.firstUpperCase(ADJECTIVE[StringUtil.hexToInt(md5.substring(11, 21), max: ADJECTIVE.length)]);
    var _noun = StringUtil.firstUpperCase(NOUN[StringUtil.hexToInt(md5.substring(21, 32), max: NOUN.length)]);
    return '$_verb$_adjective$_noun';
  }

  static String METHOD_NAME(String md5) {
    var _verb = VERB[StringUtil.hexToInt(md5.substring(0, 11), max: VERB.length)].toUpperCase();
    var _adjective = StringUtil.firstUpperCase(ADJECTIVE[StringUtil.hexToInt(md5.substring(11, 21), max: ADJECTIVE.length)]).toUpperCase();
    var _noun = StringUtil.firstUpperCase(NOUN[StringUtil.hexToInt(md5.substring(21, 32), max: NOUN.length)]).toUpperCase();
    return '${_verb}_${_adjective}_$_noun';
  }

  static String field_name(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 4), max: ADJECTIVE.length);
    var list = [ADJECTIVE[num]];
    num = StringUtil.hexToInt(md5.substring(4, 10), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(10, 16), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(ADJECTIVE[num]);
    num = StringUtil.hexToInt(md5.substring(16, 22), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(22, 28), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(ADJECTIVE[num]);
    num = StringUtil.hexToInt(md5.substring(28, 32), max: NOUN.length);
    return (list..add(NOUN[num])).join('_');
  }

  static String fieldName(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 4), max: ADJECTIVE.length);
    var list = [ADJECTIVE[num]];
    num = StringUtil.hexToInt(md5.substring(4, 10), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(StringUtil.firstUpperCase(NOUN[num]));
    num = StringUtil.hexToInt(md5.substring(10, 16), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(StringUtil.firstUpperCase(ADJECTIVE[num]));
    num = StringUtil.hexToInt(md5.substring(16, 22), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(StringUtil.firstUpperCase(NOUN[num]));
    num = StringUtil.hexToInt(md5.substring(22, 28), max: ADJECTIVE.length * 2);
    if (num < ADJECTIVE.length) list.add(StringUtil.firstUpperCase(ADJECTIVE[num]));
    num = StringUtil.hexToInt(md5.substring(28, 32), max: NOUN.length);
    return (list..add(StringUtil.firstUpperCase(NOUN[num]))).join('');
  }

  static String color(String md5) {
    var num = StringUtil.hexToInt(md5.substring(0, 8), max: ADJECTIVE.length);
    var list = [ADJECTIVE[num]];
    num = StringUtil.hexToInt(md5.substring(8, 16), max: NOUN.length * 2);
    if (num < NOUN.length) list.add(NOUN[num]);
    num = StringUtil.hexToInt(md5.substring(16, 24), max: NOUN.length);
    list.add(NOUN[num]);
    return '    <color name="${list.join('_')}">#${md5.substring(24, 32)}</color>';
  }
}
