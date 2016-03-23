package com.devcamp.yapp.db.Dto;

/**
 * Created by Beomjun on 2016-02-27.
 */
public class TableDto {
    int id;
    String mainText;
    String subText1;
    String subText2;
    String subText3;
    String subText4;
    String subText5;
    String subText6;
    String subText7;
    String subText8;

    int main_state;
    int sub1_state;
    int sub2_state;
    int sub3_state;
    int sub4_state;
    int sub5_state;
    int sub6_state;
    int sub7_state;
    int sub8_state;

    public int getId(){return id;}
    public void setId(int id){this.id = id;}

    public String getMainText(){return mainText;}
    public void setMainText(String txt){  mainText = txt; }
    public void setMain_state(int s){main_state = s;}
    public int getMain_state(){return main_state;}

    public String getSubText1(){return subText1;}
    public void setSubText1(String txt){subText1 = txt;}
    public void setSub1_state(int s){sub1_state = s;}
    public int getSub1_state(){return sub1_state;}

    public String getSubText2(){return subText2;}
    public void setSubText2(String txt){subText2 = txt;}
    public void setSub2_state(int s){sub2_state = s;}
    public int getSub2_state(){return sub2_state;}

    public String getSubText3(){return subText3;}
    public void setSubText3(String txt){subText3 = txt;}
    public void setSub3_state(int s){sub3_state = s;}
    public int getSub3_state(){return sub3_state;}

    public String getSubText4(){return subText4;}
    public void setSubText4(String txt){subText4 = txt;}
    public void setSub4_state(int s){sub4_state = s;}
    public int getSub4_state(){return sub4_state;}

    public String getSubText5(){return subText5;}
    public void setSubText5(String txt){subText5 = txt;}
    public void setSub5_state(int s){sub5_state = s;}
    public int getSub5_state(){return sub5_state;}

    public String getSubText6(){return subText6;}
    public void setSubText6(String txt){subText6 = txt;}
    public void setSub6_state(int s){sub6_state = s;}
    public int getSub6_state(){return sub6_state;}

    public String getSubText7(){return subText7; }
    public void setSubText7(String txt){subText7 = txt;}
    public void setSub7_state(int s){sub7_state = s;}
    public int getSub7_state(){return sub7_state;}

    public String getSubText8(){return subText8;}
    public void setSubText8(String txt){subText8 = txt;}
    public void setSub8_state(int s){sub8_state = s;}
    public int getSub8_state(){return sub8_state;}
}
