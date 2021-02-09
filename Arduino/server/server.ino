// parameters
// 10 - switch 1 is off
// 11 - switch 1 is on
// 20 - switch 2 is off
// 21 - switch 2 is on
// 12 - read status from switch1
// 22 - read status from switch2

#include "etherShield.h"
#include "ETHER_28J60.h"
 
static uint8_t mac[6] = {0x54, 0x55, 0x58, 0x10, 0x00, 0x24};   
static uint8_t ip[4] = {192, 168, 1, 63};                      
static uint16_t port = 80;
const int SW1 = 2;
const int SW2 = 3;
 
ETHER_28J60 ethernet;
 
void setup() {
  pinMode(SW1, OUTPUT);
  pinMode(SW2, OUTPUT);
  digitalWrite(SW1, LOW);
  digitalWrite(SW2, LOW);
  ethernet.setup(mac, ip, port);  
}


void loop() {
  char* param;
  if (param = ethernet.serviceRequest()) {
      if (strcmp(param, "10") == 0) {
        ethernet.print(switcher(SW1, false));
    } else if (strcmp(param, "11") == 0) {
        ethernet.print(switcher(SW1, true));
    } else if (strcmp(param, "20") == 0) {
        ethernet.print(switcher(SW2, false));
    } else if (strcmp(param, "21") == 0) {
        ethernet.print(switcher(SW2, true));
    } else if (strcmp(param, "12") == 0) {
        ethernet.print(digitalRead(SW1));
    } else if (strcmp(param, "22") == 0) {
        ethernet.print(digitalRead(SW2));
    }

    ethernet.respond();
  }
  delay(100);
}


boolean switcher(int sw, boolean key) {
  if (key) {
    digitalWrite(sw, HIGH);
  } else {
    digitalWrite(sw, LOW);
  }
  return digitalRead(sw);
}
