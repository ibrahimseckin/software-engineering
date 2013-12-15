package getServices.model;

public class Offers {
    private int id;
    private int requestId;
    private int providerId;
    private int price;
    private String exp;
    
    public Offers(){}
    
    public Offers(int requestId, int providerId, int price, String exp){

        this.requestId =  requestId;
        this.providerId =  providerId;
        this.price =  price;
        this.exp = exp;
    
    }
    
    public int getId(){
        return id;
    }
    
    public void setId(int id){
        this.id = id;    
    }
    
    public int getRequestId(){
        return requestId;
    }
    
    public void setRequestId(int requestId){
        this.requestId = requestId;    
    }
    public int getProviderId(){
        return providerId;
    }
    
    public void setproviderId(int providerId){
        this.providerId = providerId;    
    }
    
    public int getPrice(){
        return price;
    }
    
    public void setPrice(int price){
        this.price = price;    
    }
    
    public String getExp(){
        return exp;
    }
    
    public void setExp(String exp){
        this.exp = exp;    
    } 
}