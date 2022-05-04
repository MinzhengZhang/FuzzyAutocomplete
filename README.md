# Fuzzy Autocomplete
___
## Description: 
Autocomplete, or word completion is a widely used feature in modern applications, where the application predicts what word the user is trying to type. In this project,
we intend to build a "fuzzy" autocomplete, where the user's spell might be wrong but will still be able to get suggestions on the word that he/she is trying to find.
Moreover, the user will get suggestions on the phrases related to the word they are typing. We will use different algorithms to generate suggestions based on spells, 
pronunciations and the actual distances on the keyboard.
___
## Technologies & Design Pattern:
- [Spring Framework](https://spring.io)
- [Apache Maven](https://maven.apache.org)
- [Apache Commons](https://commons.apache.org)
- [Model View Controller (MVC) Design Pattern](https://en.wikipedia.org/wiki/Model%E2%80%93view%E2%80%93controller)
- [Dependency Injection Design Pattern](https://en.wikipedia.org/wiki/Dependency_injection) and [Inverse of Control (IoC)](https://en.wikipedia.org/wiki/Inversion_of_control)
___
## Data Structures:
- [BK-Tree](https://en.wikipedia.org/wiki/BK-tree) (to build index for quick word search by Levenshtein Distance)
- Hash Table (to map search results to the links)
- Trie (to build index for phonetic search)
- ArrayList (to keep search results)
___
## Algorithms
- [Levenshtein Distance](https://en.wikipedia.org/wiki/Levenshtein_distance)
- [Jaro-Winkler Distance Score](https://en.wikipedia.org/wiki/Jaro%E2%80%93Winkler_distance)
- Keyboard Weighting
- [Double Metaphone Algorithm](https://en.wikipedia.org/wiki/Metaphone#Double_Metaphone)
___
## General Work Breakdown
- Xinyue Liu: Framework setup, GUI
- Minzheng Zhang: Implemention of Levenshtein Distance and Keyboard weighting.
- Zijian Xiao: Implementation of Jaro-Winkler Distance Score and BK-Tree.
