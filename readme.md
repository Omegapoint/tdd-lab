# TDD 101 - labbar

Denna kodbas utgör basen i labbarna i TDD-kursen. Innehållet är avsiktligt knapphändigt då respektive deltagare förväntas utöka koden i varje labbmoment.

## Innehåll

- [TDD 101 - labbar](#tdd-101---labbar)
  - [Innehåll](#innehåll)
  - [Förkrav - Detta behöver du inför kurstillfället](#förkrav---detta-behöver-du-inför-kurstillfället)
    - [Editor](#editor)
    - [Git](#git)
    - [JDK Java Development Kit Version 17](#jdk-java-development-kit-version-17)
      - [Mac](#mac)
      - [Windows](#windows)
    - [Öppna och testkör koden](#öppna-och-testkör-koden)
      - [SSH Adding SSH keys to your github account](#ssh-adding-ssh-keys-to-your-github-account)
      - [https](#https)
  - [Kursprogram](#kursprogram)
    - [Förväntningar](#förväntningar)
    - [Vad är TDD?](#vad-är-tdd)
    - [Varför?](#varför)
    - [Junit exempel](#junit-exempel)
    - [Mobbprogrammering](#mobbprogrammering)
    - [Övning 1](#övning-1)
    - [Paus](#paus)
    - [Miniretro - vad har vi lärt oss?](#miniretro---vad-har-vi-lärt-oss)
    - [Några verktyg](#några-verktyg)
    - [Introducera 'Lyckliga zonen' och 'Den hemska världen därute'](#introducera-lyckliga-zonen-och-den-hemska-världen-därute)
    - [Mockito exempel](#mockito-exempel)
    - [Övning 2: Introducera en kollaboratör](#övning-2-introducera-en-kollaboratör)
    - [Återsamling, återblick:](#återsamling-återblick)
    - [Fler verktyg](#fler-verktyg)
    - [Lite generellt om testning om någon undrar](#lite-generellt-om-testning-om-någon-undrar)
      - [Testpyramiden](#testpyramiden)
      - [Egenskaper](#egenskaper)
      - [Andra metoder och sätt](#andra-metoder-och-sätt)
  - [Referenser - för den nyfikne](#referenser---för-den-nyfikne)

## Förkrav - Detta behöver du inför kurstillfället

### Editor

_För att kunna redigera och köra koden behövs en editor. Vi föreslår IntelliJ._

- [IntelliJ](https://www.jetbrains.com/idea/download/)
- [Eclipse](https://www.eclipse.org/ide/)
- [VS Code](https://code.visualstudio.com/download)

### Git

<https://git-scm.com/book/en/v2/Getting-Started-Installing-Git>

### JDK Java Development Kit Version 17

#### Mac

- [Brew](https://formulae.brew.sh/formula/openjdk@17) (Mac- och unix-användare)
  - `brew install openjdk@17`
- [Ladda ned från Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

#### Windows

TODO: Uppdatera README med windows. Lämna gärna in en PR med förslag på vad som kan stå här.

### Öppna och testkör koden

Öppna en terminal och navigera till det stället du vill spara lab-koden `cd ~/SOME_DIRECTORY` Välj något bra ställe som /Documents/labs t.ex. Därefter klonar du med SSH eller https (Välj https om du inte använt SSH tidigare)

#### SSH [Adding SSH keys to your github account](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

`git clone git@github.com:Omegapoint/tdd-lab.git`

#### https

`git clone https://github.com/Omegapoint/tdd-lab.git`

Öppna IntelliJ och välj att öppna foldern /tdd-lab som du precis skapade med `git clone`

I IntelliJ kan du högerklicka på filen `CalculatorTest` under `src/test/java/se.omegapoint.academy.tdd/example/` och tryck `Run 'CalculatorTest'`

Testet ska då gå igenom. Då är allt uppsatt för att du ska kunna påbörja kursen utan några vidare installationer, sen är det bara att skriva kod.

## Kursprogram

Ungefär såhär brukar vi lägga upp kursen.

### Förväntningar

Samla in förväntningar.

### Vad är TDD?

Test Driven Design

- Skriv ett test som beskriver en önskad egenskap
- Observera att det fallerar på ett förväntat och begripligt sätt
- Se till att testet passerar på det enklaste sättet
- Se över resultatet t.ex. vad gäller namn och struktur
- Ändra och kontrollera att testet inte fallerar
- Börja från början så länge man kan komma på nya egenskaper.

### Varför?

- Var snäll mot dig själv i framtiden!
- Specifikation.
- Skyddar önskade egenskaper.
- Tvingar fram en enkel lösning.
- Små steg.

### Junit exempel

Se ConversionTest.

### Mobbprogrammering

- En förare, många navigatörer.
- Byt förare ungefär var 10e minut.
- Man får säga pass!
- Man får gå ut och ta paus.
- Kom ihåg turtagande och hänsyn.

### Övning 1

Varukorgen ska kunna visas i ett användargränssnitt.

- Antalet varor i korgen
- Totala priset för alla varor i korgen.
- En lista med beskrivningar; namn och pris

### Paus

### Miniretro - vad har vi lärt oss?

### Några verktyg

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

### Introducera 'Lyckliga zonen' och 'Den hemska världen därute'

Lösning: Dubbelgångare

### Mockito exempel

Se CollaborationTest.

### Övning 2: Introducera en kollaboratör

Se till att priser slås upp med hjälp av prissättningstjänsten.
Vad händer?

- Verifiera att priser hämtas från prissättningstjänsten.

### Återsamling, återblick:

### Fler verktyg

- Dubbelgångare
  - <b>Mockito</b>
  - Easymock
  - Powermock
  - Spock (groovy)

### Lite generellt om testning om någon undrar

#### Testpyramiden

- Enhet
- Integration
- Funktion
- End to end (E2E)
- Acceptans
- System
- Prestanda

#### Egenskaper

- Exekveringstid
- Målgrupp
- Stabilitet
- Beroenden

#### Andra metoder och sätt

- BDD: Behaviour-Driven Development
- ATDD: Acceptance Test Driven Development
- Property based testing
- Mutation testing

## Referenser - för den nyfikne

- Video: tifrån och in - TDD för bättre design och tidigare feedback - Thomas Nilefalk: https://www.youtube.com/watch?v=8bUrjHWlDMY
- Blog: TestPyramid - Martin Fowler: https://martinfowler.com/bliki/TestPyramid.html
- Blog: Integrated tests are a scam - J.B. Rainsberger
  http://blog.thecodewhisperer.com/permalink/integrated-tests-are-a-scam
- Bok: Growing object-oriented software guided by tests: http://www.adlibris.com/se/bok/growing-object-oriented-software-guided-by-tests-9780321503626
- Bok: https://pragprog.com/book/utj2/pragmatic-unit-testing-in-java-8-with-junit
