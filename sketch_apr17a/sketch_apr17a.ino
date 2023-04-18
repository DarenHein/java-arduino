int led = 8 ; 
char mensaje; 
void setup() {
  // put your setup code here, to run once:
  Serial.begin(9600); 
  pinMode(led,OUTPUT); 
}

void loop() {
  // put your main code here, to run repeatedly:
  if(Serial.available()>0){
    mensaje = Serial.read(); 
    if(mensaje == 'k'){
      digitalWrite(led,HIGH); 
    }else{
      digitalWrite(led,LOW); 
    }
  }

}
