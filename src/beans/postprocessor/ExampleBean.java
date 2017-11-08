package beans.postprocessor;


public class ExampleBean {
    private String message;

    public void setMessage(String message){
        this.message  = message;
    }
    public void getMessage(){
        System.out.println("Your Message : " + message);
    }
    public void init(){
        System.out.println("Bean ("+ message +") is going through init.");
    }
    public void destroy(){
        System.out.println("Bean ("+ message +") will destroy now.");
    }
}
