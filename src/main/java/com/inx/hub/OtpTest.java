package com.inx.hub;

import com.amdelamar.jotp.OTP;
import com.amdelamar.jotp.type.Type;

//https://blog.csdn.net/modelmd/article/details/133242988?utm_medium=distribute.pc_relevant.none-task-blog-2~default~baidujs_baidulandingword~default-0-133242988-blog-132469499.235^v38^pc_relevant_sort&spm=1001.2101.3001.4242.1&utm_relevant_index=3
public class OtpTest {

    public static void main(String[] args) {
      try {
          String hexTime = OTP.timeInHex(System.currentTimeMillis(), 30);
          String secret = "CPM3B6NAVUDGVWDM";
          String code = OTP.create(secret, hexTime, 6, Type.TOTP);
          System.out.println(code);
      }catch (Exception e){
          e.printStackTrace();
      }

    }
}
