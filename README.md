# Laboratory Work 5 — Event Registration

Java 17 console application using OOP and an in-memory `ArrayList`.

## Classes
- `Registration` stores one registration with private fields, constructor, getters and `toString()`.
- `RegistrationManager` validates and manages registrations, assigns non-reused IDs, searches, deletes and filters.
- `Main` reads console input, shows the menu and handles invalid numeric input.

## Run
Open the folder as a Gradle project in IntelliJ IDEA with JDK 17 or later and run `registration.Main.main()`.
Alternatively, with Gradle installed run `gradle run` from the project directory.
No external libraries or database are needed.

## Menu
1 Add; 2 Show all; 3 Find by ID; 4 Delete by ID; 5 Filter by event; 0 Exit.

## Validation
Name at least 3 characters after trim, email has text before and after @, group not blank, event from the three choices. Invalid entries are not saved.
