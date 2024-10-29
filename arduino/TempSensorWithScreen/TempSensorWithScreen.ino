#include <LiquidCrystal.h>
LiquidCrystal lcd(12, 11, 5, 4, 3, 2);
float maxTemp = 0;
float minTemp = 100;

void setup() {
  lcd.begin(16, 2);
  Serial.begin(9600);
  lcd.print(":3    Temp    :P");
  lcd.setCursor(0, 1);
}

void loop() {
  int sensorVal = analogRead(A0);
  float voltage = (sensorVal/1024.0) * 5.0;
  float temp = (voltage - 0.5) * 100;
  Serial.println(temp);

  if (temp > maxTemp) {
    maxTemp = temp;
  }

  if (temp < minTemp) {
    minTemp = temp;
  }

  lcd.print(minTemp);
  lcd.setCursor(5, 1);
  lcd.print(" - ");
  lcd.setCursor(8, 1);
  lcd.print(maxTemp);
  lcd.setCursor(0, 1);
}

