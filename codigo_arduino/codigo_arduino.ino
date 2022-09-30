const int btnAnterior = 2;
const int btnReproducir = 3;
const int btnPausar = 4;
const int btnSiguiente = 5;
const int btnLoop = 6;
const int btnFav = 7;


const int luz1 = 9;
const int luz2 = 10;
const int luz3 = 11;
const int luz4 = 12;
const int luz5 = 13;

const int ledNose = 9;
int dato = 0;
double valor;
double cantLuces = 0;

void setup() {
  // put your setup code here, to run once:
  pinMode(btnAnterior,INPUT);
  pinMode(btnReproducir,INPUT);
  pinMode(btnPausar,INPUT);
  pinMode(btnSiguiente,INPUT);
  pinMode(btnLoop,INPUT);

  pinMode(luz1,OUTPUT);
  pinMode(luz2,OUTPUT);
  pinMode(luz3,OUTPUT);
  pinMode(luz4,OUTPUT);
  pinMode(luz5,OUTPUT);
  Serial.begin(9600); 
  
}

void loop() {
  

  valor = analogRead(A0);
  Serial.print(valor);
  // put your main code here, to run repeatedly:
  if(digitalRead(btnAnterior) == HIGH){
      Serial.println(",1");
  }
  else if(digitalRead(btnReproducir) == HIGH){
    
      Serial.println(",2");
  
       
  }
  else if(digitalRead(btnPausar) == HIGH){
    
      Serial.println(",3");
    
  }
  else if(digitalRead(btnSiguiente) == HIGH){
      Serial.println(",4");    
  }
  else if(digitalRead(btnLoop) == HIGH){
      Serial.println(",5");    
  }
  else if(digitalRead(btnFav) == HIGH){
      Serial.println(",6");    
  }
  else{
    Serial.println(",0");  
  }
  


  //Lectura Serial

  int serial = Serial.parseInt();  
  cantLuces = valor / 197;

  if(cantLuces==0){
    digitalWrite(luz1,LOW);
    digitalWrite(luz2,LOW);
    digitalWrite(luz3,LOW);
    digitalWrite(luz4,LOW);
    digitalWrite(luz5,LOW);

  }
  if(cantLuces>=1){
    digitalWrite(luz1,HIGH);
    digitalWrite(luz2,LOW);
    digitalWrite(luz3,LOW);
    digitalWrite(luz4,LOW);
    digitalWrite(luz5,LOW);
  }
  if(cantLuces>=2){
    digitalWrite(luz1,HIGH);
    digitalWrite(luz2,HIGH);
    digitalWrite(luz3,LOW);
    digitalWrite(luz4,LOW);
    digitalWrite(luz5,LOW);
  }
  if(cantLuces>=3){
    digitalWrite(luz1,HIGH);
    digitalWrite(luz2,HIGH);
    digitalWrite(luz3,HIGH);
    digitalWrite(luz4,LOW);
    digitalWrite(luz5,LOW);
  }
  if(cantLuces>=4){
    digitalWrite(luz1,HIGH);
    digitalWrite(luz2,HIGH);
    digitalWrite(luz3,HIGH);
    digitalWrite(luz4,HIGH);
    digitalWrite(luz5,LOW);
  }
  if(cantLuces>=4.5){
    digitalWrite(luz1,HIGH);
    digitalWrite(luz2,HIGH);
    digitalWrite(luz3,HIGH);
    digitalWrite(luz4,HIGH);
    digitalWrite(luz5,HIGH);
  }



  


}
