Methodology
=======

I've started with tests to be able to refactor my code easily.
The scenarios are well described in requirements.

It was easy to have 100% GildedRose code coverage since it is a kata with only one class.
But in real life legacy applications, it can be difficult to cover the code with only unit tests if the code in not clean and not respecting some principles (like SOLID).
Integration tests may help in that cases but we should keep in mind TestPyramid (https://martinfowler.com/bliki/TestPyramid.html).

To refactor the code, I used the development environment tool to : 
- invert, split, join conditions
- extract methods
- extract constants
- encapsulate members
- convert to instance methods
- ...

with one idea in mind : separate the behavior of items based on their types.

[![BCH compliance](https://bettercodehub.com/edge/badge/benmlahzied/GildedRoseRefactoringKata?branch=master)](https://bettercodehub.com/)


