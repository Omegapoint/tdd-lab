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
  - [Lab-instruktioner](#lab-instruktioner)
  - [Referenser - för den nyfikne](#referenser---för-den-nyfikne)

## Förkrav - Detta behöver du inför kurstillfället

- Editor
- Git
- JDK17

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

- [Ladda ned från Oracle](https://www.oracle.com/java/technologies/javase/jdk17-archive-downloads.html)

TODO: Lägg till instruktioner om installationen.
(Windows-användare som läser kursen får gärna lägga upp en PR med instruktioner.)

### Öppna och testkör koden

Öppna en terminal och navigera till det stället du vill spara lab-koden `cd ~/SOME_DIRECTORY` Välj något bra ställe som /Documents/labs t.ex. Därefter klonar du med SSH eller https (Välj https om du inte använt SSH tidigare)

#### SSH [Adding SSH keys to your github account](https://docs.github.com/en/authentication/connecting-to-github-with-ssh/adding-a-new-ssh-key-to-your-github-account)

`git clone git@github.com:Omegapoint/tdd-lab.git`

#### https

`git clone https://github.com/Omegapoint/tdd-lab.git`

Öppna IntelliJ och välj att öppna foldern /tdd-lab som du precis skapade med `git clone`

I IntelliJ kan du högerklicka på filen `CalculatorTest` under `src/test/java/se.omegapoint.academy.tdd/example/` och tryck `Run 'CalculatorTest'`

Testet ska då gå igenom. Då är allt uppsatt för att du ska kunna påbörja kursen utan några vidare installationer, sen är det bara att skriva kod.

## Lab-instruktioner

Lab-instruktionerna hittar du i presentationsformat i filen [TDD-Presentation-2.0.key](TDD-Presentation-2.0.key). Ladda ner den och följ instruktionerna för att genomföra labben på egen hand. [Kravordning.txt](Kravordning.txt) innehåller i vilken ordning du får dina krav från din produktägare.

Kan du inte läsa .key formatet kan du köra filen genom en KeyNote -> PowerPoint formatterare online.

## Referenser - för den nyfikne

- Video: utifrån och in - TDD för bättre design och tidigare feedback - Thomas Nilefalk: https://www.youtube.com/watch?v=8bUrjHWlDMY
- Blog: TestPyramid - Martin Fowler: https://martinfowler.com/bliki/TestPyramid.html
- Blog: Integrated tests are a scam - J.B. Rainsberger
  http://blog.thecodewhisperer.com/permalink/integrated-tests-are-a-scam
- Bok: Growing object-oriented software guided by tests: http://www.adlibris.com/se/bok/growing-object-oriented-software-guided-by-tests-9780321503626
