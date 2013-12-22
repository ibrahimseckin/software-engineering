package getServices.model;

public class Offers {
    private int id;
    private int requestId;
    private int providerId;
    private int price;
    private String exp;
    private boolean selected;
    private Provider provider;
    
    public Offers(){}
    
    public Offers(int id, int requestId, int providerId, int price, String exp, boolean selected){
        this.id = id;
        this.requestId = requestId;
        this.providerId =  providerId;
        this.price =  price;
        this.exp = exp;
        this.selected = selected;
        this.provider = new Provider();
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

    public boolean isSelected() {
        return selected;
    }

    public void setSelected(boolean selected) {
        this.selected = selected;
    }

    public Provider getProvider() {
        return provider;
    }

    public void setProvider(Provider provider) {
        this.provider = provider;
    }
}