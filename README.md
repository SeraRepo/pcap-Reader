# PCAP Reader

Projet réseau, programmer en java une application CLI qui permet de prendre un fichier PCAP en entrée et le parser.

Le binaire rendu doit être capable de parser un fichier .pcap donné en entrée et d'afficher chaque packet intercepté avec ses informations importantes. Il doit être capable de suivre un flux TCP et de filtrer les différents protocoles.

Les différents protocols analysés sont les suivants: 
    - Ethernet / ARP
    - IPv4 /ICMP
    - UDP
    - TCP
    - HTTP
    - DNS
    - QUIC
    - DHCP

Les librairies authorisées sont les suivantes: io, net, utils, lang.