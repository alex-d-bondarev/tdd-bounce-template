# tdd-bounce-template
=====================

Template for team TDD practice

Rules
-----

### Rule #1

1. Always start with a test. A test should fail. Do not write any production code if there is no failing test.
1. As soon as you have a failing test implement production code that makes it pass. Do not refactor any code until the test passes.
1. As soon as the test passes start test and production code refactoring.

Repeat these steps until expected behavior is implemented.

### Rule #2 

See rule #1... and implement tests:

Always start with the minimum test: pass null -> pass the simplest smallest value. Test complexity should grow slowly.
Stop adding tests as soon as feature is implemented.

### Rule #3

See rule #1... and refactor:

Follow a TTP approach. TTP stands for Transformation Priority Premise. In theory TTP makes your code more optimized. 
Looks like that the opposite was not proven yet. The idea is that refactoring should be done step by step in the 
[following order](https://en.wikipedia.org/wiki/Transformation_Priority_Premise): 

1. ({} → nil) no code at all → code that employs nil
1. (nil → constant)
1. (constant → constant+) a simple constant to a more complex constant
1. (constant → scalar) replacing a constant with a variable or an argument
1. (statement → statements) adding more unconditional statements.
1. (unconditional → if) splitting the execution path
1. (scalar → array)
1. (array → container)
1. (statement → tail-recursion)
1. (if → while)
1. (statement → non-tail-recursion)
1. (expression → function) replacing an expression with a function or algorithm
1. (variable → assignment) replacing the value of a variable.
1. (case) adding a case (or else) to an existing switch or if

### Rule #4

When working in pairs do the following:

1. A pair should use only 1 laptop
1. Person #1 implements failing test and passes laptop to person #2
1. Person #2 makes test to pass
1. Person #2 refactors an implemented code
1. Person #2 implements the next failing test and the flow starts from the beginning. 

Practice tasks
--------------

### Prerequisites

1. Fork this repository.
1. Ensure that Java 8 is installed.
1. Ensure that Maven is installed.
1. Run `mvn clean install` to confirm that your environment is ready
1. Run [Main](src/main/java/org/practice/app/Main.java) class via terminal or your favorite IDE, just for fun (try `UP` key).

### Tasks

#### Add support for _left_ button

When `Left` button is pressed a ball should move _left_, until `Left` is released.

```
---------------------      ---------------------
|                   |      |                   |
|             ()    |  =>  |   ()              |
|                   |      |                   |
---------------------      ---------------------
```

#### Add support for _down_ button

When `Down` button is pressed a ball should move _down_, until `Down` is released.

```
---------------------      ---------------------
|                   |      |                   |
|             ()    |  =>  |                   |
|                   |      |             ()    |
---------------------      ---------------------
```

#### Add support for _right_ button
                     
When `Right` button is pressed a ball should move _right_, until `Right` is released.

```
---------------------      ---------------------
|                   |      |                   |
|   ()              |  =>  |             ()    |
|                   |      |                   |
---------------------      ---------------------
```

#### Add block entities

It should be possible to render block entities (see [sprites](src/main/resources/sprites) -> square).
Block entity should have the same size as the ball.

```
---------------------      ---------------------
|                   |      |                 |_|
|   ()              |  =>  |   ()              |
|                   |      |                   |
---------------------      ---------------------
```

#### Add corner entities

It should be possible to render corner entities (see [sprites](src/main/resources/sprites)): 
- left_bottom
- left_top
- right_bottom
- right_top
Corner entities should have the same size as the ball.

```
---------------------      ---------------------
|                   |      |/                 \|
|   ()              |  =>  |   ()              |
|                   |      |\                 /|
---------------------      ---------------------
```

#### Add gravity

When no buttons are pressed the ball should fall to screen bottom.

```
---------------------      ---------------------
|                   |      |                   |
|   ()              |  =>  |                   |
|                   |      |   ()              |
---------------------      ---------------------
```

#### Add square block left and right collision

When ball is moving left or right it should not go through the square block.
_Do not add top and bottom collision._

```
---------------------      ---------------------
|                   |      |                   |
|               _   |  =>  |               _   |
|   ()         | |  |      |            ()| |  |
---------------------      ---------------------
```

#### Add jump functionality

When Up button is pressed then the ball should start jumping:
- As soon as jump button is released the jump should stop;
- Jump should no be higher than 3 square blocks
- Jump should not be lower than 1 square block

```
---------------------      ---------------------
|               _   |      |               _   |
|              |_|  |      |              |_|  |
|              |_|  |      |              |_|  |
|              |_|  |  =>  |   max      ()|_|  |
|              |_|  |      |            ()|_|  |
|              |_|  |      |   min      ()|_|  |
|            ()| |  |      |              | |  |
---------------------      ---------------------
```

#### Draw screen border

Render lines that highlight map borders.
Map should be 5px smaller than screen size from each side (like margin in html).
All entities should be rendered inside map.
The ball should not be able to cross the map border.

#### Add properties support

Property file should store at least the following data:
- ball speed
- entity size
- ball starting position
- map margin (optional, 5px by default).

#### Add map support

Map should not be hardcoded. Instead it should be loaded from another property file.
The first line in file should have map `width` and `height`.
The rest of the lines should represent the map divided in entity size blocks like:
```
0000000000
0001000000
0000234560
```
Where the numbers represent:
0 - nothing
1 - ball
2 - left_bottom
3 - left_top
4 - right_bottom
5 - right_top
6 - block

_This task deprecates ball starting position from previous task. Heh, like changing requirements in real life:)_

Summary
-------

### Discuss TDD steps each teammate or pair followed.

- Did you manage to follow all TDD rules?
- Do you think TDD can help you?

### Have fun

There are some [sprites](src/main/resources/sprites) that were not described in Tasks section. 
In theory they should be enough to implement Bounce mobile game from old Nokia color phones.
You still did not implement (I hope so, otherwise you did not follow TDD) cases, such as:
- ball jumps on block or corner blocks;
- move to/over corner blocks
- rings can be collected
- spikes can trigger `Game Over`
- etc.
