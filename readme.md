# Basket
Denna kodbas utgör basen i labbarna i TDD-kursen. Innehållet är avsiktligt knapphändigt då respektive deltagare förväntas utöka koden i varje labbmoment.

## Förväntningar

Samla in förväntningar.

## Vad är TDD?

Test Driven Design

- Skriv ett test som beskriver en önskad egenskap
- Observera att det fallerar på ett förväntat och begripligt sätt
- Se till att testet passerar på det enklaste sättet
- Se över resultatet t.ex. vad gäller namn och struktur
- Ändra och kontrollera att testet inte fallerar
- Börja från början så länge man kan komma på nya egenskaper.

## Varför?

- Var snäll mot dig själv i framtiden!
- Specifikation.
- Skyddar önskade egenskaper.
- Tvingar fram en enkel lösning.
- Små steg.

## Junit exempel

Se ConversionTest.

## Mobbprogrammering
 
 - En förare, många navigatörer.
 - Byt förare ungefär var 10e minut.
 - Man får säga pass!
 - Man får gå ut och ta paus.
 - Kom ihåg turtagande och hänsyn.
 
## Övning

Varukorgen ska kunna visas i ett användargränssnitt.

- Antalet varor i korgen
- Totala priset för alla varor i korgen.
- En lista med beskrivningar; namn och pris

## Paus 

## Miniretro - vad har vi lärt oss?

## Verktyg

- Testkörare: 
    - <b>JUnit</b>
    - TestNG
    - Spek (Kotlin)
    - Spock (groovy)
    - Cucumber
    - Scalatest (Scala)
- Assertions: 
    - <b>AssertJ</b>
    - Hamcrest
    - Junit

## Introducera 'Lyckliga zonen' och 'Den hemska världen därute'

Lösning: Dubbelgångare

## Mockito exempel

Se CollaborationTest.

## Övning 2: Introducera en kollaboratör

Se till att priser slås upp med hjälp av prissättningstjänsten.
Vad händer?

- Verifiera att priser hämtas från prissättningstjänsten.
 
## Återsamling, återblick:

## Verktyg (igen)

- Dubbelgångare
    - <b>Mockito</b>
    - Easymock
    - Powermock
    - Spock (groovy)
    
## Lite generellt om testning om någon undrar 

### Testpyramiden
- Enhet
- Integration
- Funktion
- End to end (E2E)
- Acceptans
- System
- Prestanda

### Egenskaper
- Exekveringstid
- Målgrupp
- Stabilitet
- Beroenden

### Andra metoder och sätt
- BDD: Behaviour-Driven Development
- ATDD: Acceptance Test Driven Development
- Property based testing
- Mutation testing
 
## Referenser

- Video: tifrån och in - TDD för bättre design och tidigare feedback - Thomas Nilefalk: https://www.youtube.com/watch?v=8bUrjHWlDMY
- Blog: TestPyramid - Martin Fowler: https://martinfowler.com/bliki/TestPyramid.html
- Blog: Integrated tests are a scam - J.B. Rainsberger
http://blog.thecodewhisperer.com/permalink/integrated-tests-are-a-scam
- Bok: Growing object-oriented software guided by tests: http://www.adlibris.com/se/bok/growing-object-oriented-software-guided-by-tests-9780321503626









