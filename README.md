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

I also used a plugin to check the dependencies and to avoid cycles.

The quality of the code has been passed from 5/10 to 8/10 but it is possible to do more.

Almost the result is not perfect, the code is much more readable than the original version.

The last commit (https://github.com/benmlahzied/GildedRoseRefactoringKata/commit/42328890ce2620c2f3bc95757132c5cd979f0a11) was not mandatory but I prefered adding ItemUpdators instead of using Active records. 

[![BCH compliance](https://bettercodehub.com/edge/badge/benmlahzied/GildedRoseRefactoringKata?branch=master)](https://bettercodehub.com/)


