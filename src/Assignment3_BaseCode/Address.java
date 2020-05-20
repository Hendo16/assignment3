/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Assignment3_BaseCode;



/**
 *
 * @author admin
 */
class Address {
    private String strNo,StrName,sub,city,state;
    private int post;

    public Address(String strNo, String StrName,
            String sub, String city, String state, int post) {
        this.strNo = strNo;
        this.StrName = StrName;
        this.sub = sub;
        this.city = city;
        this.state = state;
        this.post = post;
    }

    @Override
    public String toString() {
        return  strNo 
                + "," + StrName + "," 
                + sub + "," + city + "," 
                + state + "," + post ;
    }

   public String getDataToSaveToTextFile() {
      return    strNo 
                + "," + StrName + "," 
                + sub + "," + city + "," 
                + state + "," + post ;
   } 
   
       public static Address getInstanceFromStringArray(String[] input)
     {        
      return new Address(input[0],input[1],input[2],input[3],input[4],Integer.valueOf(input[5]));    
     }
      
}
