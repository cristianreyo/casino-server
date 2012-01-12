package juego.Dados;

import java.net.*;
import java.util.*;
import juego.Juego;



public class JuegoDados extends Juego implements Runnable {

    Vector<Integer> apuestas = new Vector<Integer>(); //Vector con la cantidad apostada por cada jugador
    Vector<Integer> tipoApuestas = new Vector<Integer>(); //Vecto con el tipo de apuesta jugada
    Vector<JugadorDados> ganadores = new Vector<JugadorDados>(); //Vecto con el tipo de apuesta jugada

    boolean tiro=true;
    final int  ganar=0, perder=1, continuar=2;
    int estado=0;
    int punto=-1;
    int resultadoG6=continuar;
    int resultadoG8=continuar;
    
    int suma;
    Dado2 d1 = new Dado2();
    Dado2 d2 = new Dado2();
      
    
    boolean gana=false;
    Vector<Boolean> resultadoApuestas = new Vector<Boolean>(); //Vecto con el resultado de apuesta jugada
    private int eleccion;


    public JuegoDados(){
        super("dados");
    }
    

    @Override
    public void run() {
       
          Vector<JugadorDados> jugadoresC;
          int apuesta=0;
          boolean controlador=false;
          int pos;
          String ganador;
                  
        while (true) { 
            jugadoresC = (Vector<JugadorDados>) jugadores.clone(); 	 //Clono el vector de jugadores para poder acceder a el de forma concurrente
             apuesta=0;
             controlador=false;
             eleccion=0;
             tiro=true;
             estado=continuar;
             punto=-1;
             //Variables de resultados
             resultadoG6=continuar;
             resultadoG8=continuar;
             ganador="";
            
            for(JugadorDados j:jugadoresC) {
                 pos=jugadoresC.indexOf(j);
                 j.enviarControl(pos);
             }
              
            for(JugadorDados j:jugadoresC) {
                  
                  System.out.println("Enviando saldo actual....."+j.saldo);
                  j.enviarSaldo();
                  
            }
             
              for(JugadorDados j:jugadoresC) {
                  
                  System.out.println("Recibiendo tipo apuesta.....");
                 tipoApuestas.add(j.recibirTipoApuesta());
                  
              }
          
              for(JugadorDados j:jugadoresC){//Para cada elemento del vector de sockets
                  System.out.println("Apuesta recibida");
                    apuesta = j.obtenerApuesta(); //Leo el dato del bufferç
                    System.out.println("apuest "+apuesta);
                    j.decrementaSaldo(apuesta);
                    apuestas.add(apuesta);
               }    
              for(JugadorDados j:jugadoresC){
            System.out.println("Enviando saldo actual....."+j.saldo);
            }

           
           do{
    
             
            JugadorDados jaux=jugadoresC.elementAt(0);
                 d1.setValor(jaux.recibirDados());
                 d2.setValor(jaux.recibirDados());
               
             System.out.println("Dado1: "+d1.getValor()+" Dado2: "+d2.getValor());
             
                 suma= d1.getValor()+d2.getValor();
               
                 //Analizar apuestas
                //Siempre un jugador al menos debe apostar a linea de pase
                 
                 lineaDePase();
                 
                 if(controlador==false){ //Solo se analiza la primera tirada porque solo se apuesta en la primera tirada
                     
                     controlador=true;
                 
                     resultadoApuestas.add(apSiete(suma)); //Siete en el proximo lanzamiento
                     resultadoApuestas.add(apDos(suma));    //Dos siguiente lanzamiento
                     resultadoApuestas.add(apCraps(suma));  //Craps en el proxiimo lanzamiento
                     resultadoApuestas.add(apDoce(suma));   //12 en el proximo lanzamiento
                     resultadoApuestas.add(apTres(suma));   //3 proxiimo lanzamiento
                     resultadoApuestas.add(apOnce(suma));   //11 en el proximo lanzamiento
                     resultadoApuestas.add(apZona(suma)); // 3, 4, 9, 10, 11 o 12, en la siguiente tirada
                 }
                 if(resultadoG6==continuar){
                       resultadoG6=gran6(suma); //6 antes que 7
                 }
                 if(resultadoG8==continuar){
                       resultadoG8=gran8(suma); //8 antes que 7
                 }
                
                 System.out.println(""+estado);
                 //Analizar ganador
                 if(estado==continuar) {
                             jaux.enviarControl(1);//continua
		 }
                 else{
                      ganador=calcularPremios(jugadoresC);
                          
                      jaux.enviarControl(0);//para de tirar
                            
                            for(JugadorDados j:jugadoresC){
                                if(ganadores.contains(j)){
                                   j.enviaAviso("Felicidades Winner!!! Has ganado!");
                                }
                                else{
                                    j.enviaAviso("Losiento Losser!!! Has perdido");
                                }
                            }
                 }
              
           }while(estado==continuar);

            
            apuestas.clear(); //Limpio el vector de los datos de entrada
            tipoApuestas.clear();
            resultadoApuestas.clear();
            ganadores.clear();
        }
    }

   //Linea de Pase
    private void lineaDePase()
    {
        if (tiro) {
			switch (suma) {
				case 7:
				case 11:
				estado=ganar;
				break;
				case 2:
				case 3:
				case 12:
				estado=perder;
				break;
				default:
				estado=continuar;
				punto=suma;	
				tiro=false;
				break;
			}
		}
		else {
			if(suma==punto) estado=ganar;
			else if (suma==7) estado=perder;
		}	
        
	}

    
    public boolean apZona(int suma){
        
        if(suma==2 || suma==3 || suma==4 || suma==9 || suma==10 || suma==11 || suma==12){
            return true;
        }
        return false;
    }
    
    //Apuesta Cualquier Siete
    public boolean apSiete(int suma){
       
        if(suma==7){
            return true;
        }
        return false;
    }
    
    //Apeusta Craps
    public boolean apCraps(int suma){

        if(suma==2 || suma==3 || suma==12){
            return true;
        }
        return false;
    }
    
    public boolean apDos(int suma){
        if(suma==2){
            return true;
        }
        return false;
    }
    
    public boolean apDoce(int suma){
        if(suma==12){
            return true;
        }
        return false;
    }
    
  public boolean apTres(int suma){
        if(suma==3){
            return true;
        }
        return false;
    }
    
   public boolean apOnce(int suma){
        if(suma==11){
            return true;
        }
        return false;
    }
    
    public int gran6(int suma){
        if(suma==6){
            return ganar;//gana
        }
        else if(suma==7){
            return perder;//pierde
            
        }
        else {
            return continuar;
        }
            
    }
    
     public int gran8(int suma){
        if(suma==8){
            
            return ganar;//gana
        }
        else if(suma==7){
            return perder;//pierde
            
        }
        else {
            
            return continuar;
        }
            
    }

    /*Metodo para calcular la apuesta ganadora, e incrementar el saldo 
      * al jugador que halla ganado
      */

     public String calcularPremios(Vector<JugadorDados> jugadoresC){
      
         String apGanadora="";
         int apuesta;
         
         if(estado==ganar){ //Gana linea de pase
             apGanadora+="Linea de pase ";
             if(tipoApuestas.contains(0)){
                    for(JugadorDados j:jugadoresC){
                         if(j.getTipoApuesta()==0)
                         {
                             ganadores.add(j);
                             
                             if(tiro == true){
                                 j.incrementaSaldo(j.getApuesta()*2);
                             }
                             else{
                                j.incrementaSaldo(j.getApuesta());
                            }
                         
                         }
                    }
             }
         }
         else if(estado==perder)
         {
           apGanadora+="Linea de no pase ";
           
            if(tipoApuestas.contains(1)){ //Si hay alguna apuesta a Linea de no pase
                
                for(JugadorDados j:jugadoresC)
                {
                     if(j.getTipoApuesta()==1){
                         ganadores.add(j);
                          apuesta=j.getApuesta();
                         j.incrementaSaldo(apuesta);
                     }
                }
           }
         }
         
         if(resultadoG6==ganar)
         {
              apGanadora+="Gran 6 ";
              if(tipoApuestas.contains(3))
              {
                     for(JugadorDados j:jugadoresC){
                         if(j.getTipoApuesta()==3){
                              ganadores.add(j);
                                  apuesta=j.getApuesta();
                                 j.incrementaSaldo(apuesta);
                         }
                    }
              }
         }
         
         if (resultadoG8 == ganar)
         {
             apGanadora += "Gran 8 ";
             if (tipoApuestas.contains(4)) 
             {
                 for (JugadorDados j : jugadoresC) 
                 {
                     if (j.getTipoApuesta() == 4) 
                     {
                         ganadores.add(j);
                         apuesta = j.getApuesta();
                         j.incrementaSaldo(apuesta);
                     }
                 }
             }
         }
         
         for(int i=0; i<resultadoApuestas.size(); i++)
         {

            if(resultadoApuestas.elementAt(i)==true)
            {
                if(i==0)
                {
                    if(tipoApuestas.contains(6)){ //Si hay alguna apuesta aSiete
                       
                        for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==6){
                                 ganadores.add(j);
                                 apuesta=j.getApuesta();
                                 apuesta*=4;
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Siete ";
                }
                else if(i==1){
                    if(tipoApuestas.contains(7)){ //Si hay alguna apuesta a Dos
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==7){
                                 ganadores.add(j);
                                 apuesta=j.getApuesta();
                                  apuesta=apuesta*2;
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Dos ";
                }else if(i==2){
                    
                    if(tipoApuestas.contains(5)){ //Si hay alguna apuesta a Craps
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==5){
                                  ganadores.add(j);
                                 apuesta=j.getApuesta();
                                 apuesta*=7;
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Craps ";
                }else if(i==3){
                    
                    if(tipoApuestas.contains(9)){ //Si hay alguna apuesta a Doce
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==9){
                                  ganadores.add(j);
                                 apuesta=j.getApuesta();
                                 apuesta*=3;
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Doce ";
                }else if(i==4){
                    
                    if(tipoApuestas.contains(8)){ //Si hay alguna apuesta a Tres
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==8){
                                  ganadores.add(j);
                                 apuesta=j.getApuesta();
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Tres ";
                }else if(i==5){
                    
                    if(tipoApuestas.contains(10)){ //Si hay alguna apuesta aOnce
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==10){
                                  ganadores.add(j);
                                 apuesta=j.getApuesta();
                                 apuesta=apuesta*2;
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Once ";
                }else{
                    if(tipoApuestas.contains(2)){ //Si hay alguna apuesta a Zona
                       for(JugadorDados j:jugadoresC)
                        {
                             if(j.getTipoApuesta()==2){
                                  ganadores.add(j);
                                  apuesta=j.getApuesta();
                                 if(suma==2){
                                     apuesta=apuesta*2;
                                 }
                                 if( suma==3){
                                     apuesta=apuesta*3;
                                 }
                                 j.incrementaSaldo(apuesta);
                             }
                        }
                   }
                    apGanadora+="Zona ";
                }
                
            }
        }
         
             return apGanadora;
         
    }
     
    /** Metodo que añade un socket al vector y ejecuta el juego
     * @param conexion
     */
    public void anadir(Socket cliente) {
       jugadores.add(new JugadorDados(cliente));
    }

    
}
