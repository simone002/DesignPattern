interface StatoVolume{

    int getVolume();

    void aumentaVolume(int v);
    void diminusciVolume(int v);


}

class StatoSilenzioso implements StatoVolume{

    int volume;

    public int getVolume() {
        return 0;
    }

    public void aumentaVolume(int v){
        if(v>=0 && v<=100)
            this.volume+=v;
        if(this.volume>100)
            this.volume=100;
    }

    public void diminusciVolume(int v){

        if(v>=0 && v<=100)
            this.volume-=v;
        if(this.volume<0)
            this.volume=0;
    }


}

class StatoMassimo implements StatoVolume{

    int volume;

    public int getVolume() {
        return 100;
    }

    public void aumentaVolume(int v){
        if(v>=0 && v<=100)
            this.volume+=v;
        if(this.volume>100)
            this.volume=100;
    }

    public void diminusciVolume(int v){

        if(v>=0 && v<=100)
            this.volume-=v;
        if(this.volume<0)
            this.volume=0;
    }


}

class StatoNormale implements StatoVolume{

    int volume;

    public int getVolume() {
        return 50;
    }

    public void aumentaVolume(int v){
        if(v>=0 && v<=100)
            this.volume+=v;
        if(this.volume>100)
            this.volume=100;
    }

    public void diminusciVolume(int v){

        if(v>=0 && v<=100)
            this.volume-=v;
        if(this.volume<0)
            this.volume=0;
    }


}

class Context{

    private StatoVolume state;

    public Context(){
        state=new StatoNormale();
    }

    public void updateState(StatoVolume state){

        this.state=state;
    }

    public void aumentaVolume(int volume){
        this.state.aumentaVolume(volume);
    }

    public void diminusciVolume(int volume){
        this.state.diminusciVolume(volume);
    }

    public int getVolume(){
       return this.state.getVolume();
    }


}

class Client1 {


    public static void main(String[]args){
        Context c=new Context();

        System.out.println(c.getVolume());
    }
}