import serial #Import Serial Library
import datetime #Import for datetime stamp
import firebase #Send info to Firebase
import random #random number generation
import time #for sleep function

firebase = firebase.FirebaseApplication('https://power-the-future.firebaseio.com/', None) #Tells where to send data

while (1==1):
    myData = random.uniform(0.00, 5.00)
    result = firebase.post('/power', {'Reading': myData}) #posts new data to Firebase
    print(result) #Prints results on screen
    sleep(10)
