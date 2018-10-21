

int C1 = A0;
int C2 = A1;
float Vout = 0.00;
float Vin1 = 0.00;
float Vin2 = 0.00;
float Power = 0.00;
float C1R = 8300.0;
float C2R = 3000.0;
float val1 = 0.0;
float val2 = 0.0;
void setup(){
   pinMode(C1, INPUT); //assigning the input port
   pinMode(C2, INPUT);
   Serial.begin(9600); //BaudRate
}
void loop(){
  val1 = analogRead(C1);
  val2 = analogRead(C2);
  Vin1 = (val1 * 5.0) / 1024.0;
  Vin2 = (val2 * 5.0) / 1024.0;
  Power = (((Vin1) * (Vin1) / C1R) + ((Vin2) * (Vin2) / C2R)) * 1000.00;
  Serial.println(Power);
  delay(1000);
}
