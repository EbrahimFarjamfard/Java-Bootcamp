package com.digipay.store.Practice;

public class StringUtil {
    public void modifyMessage(String string, char character){
        // -- Method 1 --
        String modifiedMessage = "";
        String[] chars = string.split("");
        for (int i = 0;  i < chars.length - 1; i++){
            modifiedMessage += chars[i] + character;
        }
        modifiedMessage += chars[string.length()-1];
        System.out.println(modifiedMessage);


        // -- Method 2 --
        StringBuffer modifiedMessageBuffer = new StringBuffer(string);
        for (int i = 1 ; i < modifiedMessageBuffer.length(); i++){
            modifiedMessageBuffer.insert(i, character);
            i++;
        }
        System.out.println(modifiedMessageBuffer);
    }
}
