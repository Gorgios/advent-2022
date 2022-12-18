## advent-2022

In this repo I present my solutions of advent of code 2022 edition - https://adventofcode.com/.
Along with improving my programming skills I want to learn new language this year - Kotlin.

### Diary
#### Day 1
* It was easy warming-up exercise. I didn't experience any problem with both parts.
* Originally done in Java, because I've started with Kotiln from Day3. Rewrote to Kotilin in "oldschool way".

#### Day 2
* Another warming-up exercise, but it required more code (or only I think so ;))
* Learned Kotlin enums and when expressions, very productive day!

#### Day 3
* Declarative programming coming! I've a lot of fun with these tasks and discovered lot of operations on collections

#### Day 4
* Only thing I had to do to solve both parts, was to found intersect function. 
However, I did it already in day3, so everything went smoothly;)

#### Day 5
* I have lot of fun with this task. Learned a little about parsing in kotlin. When input is correctly parsed,
exercise become easy, because there is only need to use stacks correctly. 

#### Day 6
* Interesting puzzle. I went declarative way, but I know that I could make it working faster by iterating in loop 
and using slicing window technique. However, execution took 20 ms, so who worry ;)

#### Day 7
* Exercise took more time than I expected, because on first attempt I tried to solve it using map. After some debugging
I realized that two dirs can contains directory with same name (shame on me), so I created simple data structure to solve this problem :) 

#### Day 8
* Very pleasant puzzle, just need to correctly traverse 2D array. Solutions may not look very elegant,
* but I didn't find better way to solve it.

#### Day 9
* Tricky puzzle, my firs part one solution was not suitable for part 2, but after some debugging 
I found how to solve in simple way and make solution generic for both parts. I'm feeling more comfortable with Kotlin every day! 

#### Day 10
* Today's tasks were more easy than puzzle description may indicate. I know that my solution can look 
little bit ugly, but I did not figure out better way to solve it, sorry :) 

#### Day 11
* Part 1 was quite simple and needed only good input parsing. However, part2 was in my opinion very tricky and
it took some time for me to figure out how to solve it. After all I combine both solutions into 1 generic.

#### Day 12
* Operations on graphs it is what I like! I use BFS to find the shortest path from S to E. 
In part to I also used BFS, but in opposite way, from E to first occurrence of 'a'. Didn't have time to generify both solutions ;)

#### Day 13
* In my opinion that puzzle was one of hardest this year (can compete only with day11 part 2). I need to create proper
data structure (nested list) and method to compare lists. I had something like comparator in part1 so I did part 2 so quickly.

#### Day 14
* Both parts were pretty simple to solve! I didn't have time to figure out faster and more clever solutions,
however, I think, that provided simulations are not bad at all ;)

#### Day 15
* I went with brute force for part2 instead of trying to find a optimal solution. I was afraid it could take forever 
to complete, but it finished in 11 second, so I'm happy that another day is complete!

#### Day 16
* Definitely the hardest puzzle so far. I'm not very proud of my code. I had to introduce caching to solve problem in finite time ;).
I know my solutions are not optimal, part 1 seems to be fast, but part 2 takes about a minute.   