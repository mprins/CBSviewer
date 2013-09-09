## Architectuur

### Componenten

De runtime omgeving bestaat uit een viertal componenten, te weten:

* [Kaart server (WMS, WMTS))](#Kaart_server)
* [Gazetteer (OpenLS)](#Gazetteer)
* [Web client (browser)](#Webclient)
* [Applicatie (J5EE) server](#J5EE_Applicatie_server)

![Component diagram](images/componentdiagram.svg "Component diagram")

#### Kaart server

De kaartserver is geen onderdeel van de applicatie maar is een externe service.
De kaart server levert achtergrondkaarten in WMS en WMTS formaat 
en voorgrond (thematische) kaarten in WMS formaat. Daarnaast verzorgt de 
kaartserver legenda elementen van de voorgrond en biedt toegang tot de 
attribuut informatie. 

#### Gazetteer

De gazetteer is ook een externe service (geen applicatie onderdeel) en 
voorziet de webapplicatie van adrescoordinaten.

#### Webclient

De browser (externe component) rendert de webapplicatie, indien de browser 
ondersteuning heeft voor Javascript en CSS wordt er voorzien in een RIA client, 
zo niet dan is er een basis variant beschikbaar, dit onderscheid wordt in de 
browser gemaakt maar het is mogelijk voor de gebruiker om zelf te kiezen.

#### J5EE Applicatie server

In de hierin wordt de cbsviewer applicatie gehost. De server voert de 
verzoeken voor de client uit. Verzoeken van de client gaan om een kaart, adres coordinaten,
legenda en attribuut informatie. 