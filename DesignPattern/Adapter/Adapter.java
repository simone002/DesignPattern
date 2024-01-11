/*Immagina di avere una libreria che gestisce diversi formati di file audio, ma ora devi adattarla per gestire anche i file video. Utilizza un adattatore per consentire alla libreria di elaborare i file video come se fossero file audio.

    Definisci un'interfaccia FormatoAudio con un metodo riproduciAudio().
    Crea una classe MP3 che implementa FormatoAudio e implementa il metodo riproduciAudio().
    Definisci un'interfaccia FormatoVideo con un metodo riproduciVideo().
    Crea una classe AVI che implementa FormatoVideo e implementa il metodo riproduciVideo().
    Crea una classe AdattatoreVideoAudio che implementa FormatoAudio e contiene un'istanza di FormatoVideo. Implementa il metodo riproduciAudio() usando il metodo riproduciVideo() del formato video.
    Nel Main, crea un'istanza di MP3, un'istanza di AVI e un'istanza di AdattatoreVideoAudio. Utilizza la libreria audio per riprodurre sia il file MP3 che il file AVI attraverso l'adattatore. */


interface FormatoAudio { //target
    public void riproduciAudio(String a);

}

class MP3 implements FormatoAudio{

    public void riproduciAudio(String a){
        System.out.println("Riproduzione audio mp3: "+a);
    }
}

interface FormatoVideo{//adaptee
    public void riproduciVideo(String v);
}

class AVI implements FormatoVideo{

    public  void riproduciVideo(String v){
        System.out.println("Ripruducendo il video avi: "+v);
    }
}

class AdattatoreVideoAudio implements FormatoAudio{ //adapter
    FormatoVideo v;

    AdattatoreVideoAudio(FormatoVideo v){
        this.v=v;
    }

    public void riproduciAudio(String file){
        System.out.println("Sto utiizzando l'adattatore video-audio");
        this.v.riproduciVideo(file);
    }
}

class Client2{

    public static void main(String[]args){
        FormatoAudio a= new MP3();

        a.riproduciAudio("audio.mp3");
        
        FormatoVideo v=new AVI();

        AdattatoreVideoAudio av=new AdattatoreVideoAudio(v);

        av.riproduciAudio("film.avi");
        
    }
}
