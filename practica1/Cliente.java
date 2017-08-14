
public class Cliente {

    String name, phone, address, mail;
    int sqrmts;
    double pvalue, svalue, margen;

    public Cliente(String name, String phone, String address, String mail, int sqrmts, double pvalue, double svalue){
        this.name = name;
        this.phone = phone;
        this.address = address;
        this.mail = mail;
        this.sqrmts = sqrmts;
        this.pvalue = pvalue;
        this.svalue = svalue;
        margen = 0;
    }

    public String findPropertyPrice(double pvalue){
        if (pvalue == this.pvalue) {
            return address;
        }
        return null;
    }

    public String findNameMarg(double margen){
        if (margen == this.margen) {
        	return name;
        }
        return null;
    }

    public String findMailMarg(double margen){
        if (margen == this.margen) {
        	return mail;
        }
        return null;
    }

    public String findPropertyMarg(double margen){
        if (margen == this.margen) {
        	return address;
        }
        return null;
    }

    public String getName(){
        return name;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getPhone(){
        return phone;
    }

    public void setPhone(String phone){
        this.phone = phone;
    }

    public  String getAddress(){
        return address;
    }

    public void setAddress(String address){
        this.address = address;
    }

    public String getMail(){
        return mail;
    }

    public void setMail(String mail){
        this.mail = mail;
    }

    public int getSqrmts(){
        return sqrmts;
    }

    public void setSqrmts(int sqrmts){
        this.sqrmts = sqrmts;
    }

    public double getPvalue(){
        return pvalue;
    }

    public void setPvalue(double pvalue){
        this.pvalue = pvalue;
    }

    public double getSvalue(){
        return svalue;
    }

    public void setSvalue(double svalue){
        this.svalue = svalue;
    }

    public double getMargen(){
        return margen;
    }

    public void setMargen(double margen){
        this.margen = margen;
    }

}