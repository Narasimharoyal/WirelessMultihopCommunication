# WirelessMultihopCommunication
It is an assignment based on real world problem for hikers and it is solved solely using JAVA

Part I.

A group of hikers (1≤N≤200) going to a remote mountainous area where there is no cellular service want to organize an emergency communication system for broadcasting important messages among themselves. 

The hikers equip themselves with walkie-talkies, one for each hiker. These walkie-talkies each have a limited transmission radius -- a walkie-talkie of transmission power W units can only transmit to other hikers less than or equal to W away. Due to the power difference of each walkie-talkie, hiker A might be able to transmit to hiker B even though hiker B may not transmit back to reach A. However, hikers can relay messages to one-another along a path consisting of several hops (multi-hop communication using intermediate hikers as relays). Therefore, it is not necessary for every hiker to be able to transmit directly to every other hiker. We can see the asymmetrical nature of the walkie-talkie transmission in this application. Hence, some hikers may be more effective in reaching larger number of other hikers than other hikers using multi-hop relay. 

In this part, you are asked to design an algorithm and write a program that implements the algorithm to determine the maximum number of hikers that can be reached by a transmission originating from a single hiker.
INPUT FORMAT (file hikernet1.txt):
The first line of input contains N.
To make the programming easy, we assume all numerical variables (e.g., N, W, etc) are integers. The next N lines each contain the x and y coordinates of a hiker (integers in the range 0…25,000) followed by W, the transmission power of the walkie-talkie held by this hiker.
OUTPUT FORMAT (file hikernet1out.txt):
Output a single line containing the maximum number of hikers a transmission from a hiker can reach. The originating hiker is included in this number.
SAMPLE INPUT:
4
1 3 5
5 4 3
7 2 1
6 1 1
SAMPLE OUTPUT:
3
In the example above, a transmission from hiker 1 can reach 3 hikers, including hiker 1.

Part II.

A potentially larger group of hikers (1≤N≤1000) going to a remote mountainous area where there is no cellular service want to organize an emergency communication system for broadcasting important messages among themselves. 
The hikers bring with them walkie-talkies, one for each hiker. These walkie-talkies each have a limited transmission radius, but as in Part I hikers can relay messages to one-another along a path consisting of several hops. Therefore, one hiker does not need to transmit directly to every other hiker.
In this part, a hiker can adjust the transmission power of his/her walkie-talkie. If he/she transmits at W units (integers), the device can reach up to a distance of √W. That is, the squared distance between two hikers must be at most W for them to be able to communicate.
Please write a program to determine the minimum integer value of transmission power W such that a transmission from any hiker will ultimately be able to reach every other hiker in the group.
INPUT FORMAT (file hikernet2.txt):
The first line of input contains N.
The next N lines each contain the x and y coordinates of a hiker. The coordinates are integers in the range 0…25,000.
OUTPUT FORMAT (file hikernet2out.txt):
Output a single line containing the integer transmission power W. That is, the minimum power the walkie-talkies must transmit at.
SAMPLE INPUT:
4
1 3
5 4
7 2
6 1
SAMPLE OUTPUT:
17



