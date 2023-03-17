# PlayingCards
This is a repo for a java pachage of a maven project that allows multiple types of the card game snap to be played in its system window.

## Contents
This repo contains all relevant files used to create the project, with appropriate inheritance, polymorphism, abstraction, and encapsulation.

## Package Notes
The Game is launch from the App.java file.
Players can navigate through multiple gametypes by using the run terminal

Testing exists in Snap.test in the test package, all public methods are tested here with appropriate labelling of their origin class.

## Website:
https://tristanpere.github.io/playingcards/

## Setup / Installation

Within your computer's terminal:
 * Locate to a directory you wish to use as a save location
 * Copy git repo url to clone it
 ### `git clone https://github.com/TristanPere/PlayingCards/`
 * Paste into terminal 
 * Change directories into /PlayingCards/
 * To pick up all the files ignored in the gitignore you can reload the maven project.

## Available Games

The menu will allow navigation through two single player games:
* One asks for a user to hit enter to cycle through the cards until two of the same value are dealt, then a snap is detected and the player wins. The
* One asks for a user to type snap when ever two of the same value are dealt in a row to gain score.
There is also the ability to select multiplayer games:
* Both games have a 2 second timer for each player to take a turn.
* 1v1 pits two players against eachother, is a snap appears on a players turn and they type snap in time they win the game.
* Free4All allows up to 14 players to play snap against eachother. To win the game each player must type their number when a snap appears, first to do so wins.
All games can be navigated through using the run terminal even after a match completion.
