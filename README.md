# HWR OOP Project Dame

[TODO]: # (Change README.md Headline to better fit to your project!)

This repository contains a student project created for an ongoing lecture on object-oriented programming with Java at HWR Berlin (summer term 2022).

> :warning: This code is for educational purpose only. Do not rely on it!

## Abstract

(Write a short description of your project.)<br/>
Es handelt sich hierbei um ein Dame-Spiel in der 8x8 Variante, welches durch die Benutzereingabe über die Konsole gespielt werden kann.<br/>
(State most important features.)<br/>
Man kann seine Partie unterbrechen und wann anders fortsetzen - durch speichern und laden von Spielständen.<br/>
(State the most interesting problems you encountered during the project.)<br/>
X und Y ist nicht immer gleich X und Y.
## Feature List

[TODO]: # (For each feature implemented, add a row to the table!)

| Number | Feature                                        | Tests                                                                                                     |
|--------|------------------------------------------------|-----------------------------------------------------------------------------------------------------------|
| 1      | Darstellung des Spielfeldes<br/>(über Konsole) | hwr.oop.ManuellTest.play_game<br/>hwr.oop.DameTest.field_initial_positions<br/>hwr.oop.DameTest.spielfeld |
| 2      | Verhalten von Spielfiguren                     | hwr.oop.DameTest.dame_move<br/>hwr.oop.DameTest.spielzüge                                                     |
| 3      | Spielbarkeit durch Benutzereingaben            | hwr.oop.ManuellTest.play_game                                                                             |
| 4      | Import/ Export von Spielfeldzuständen          | hwr.oop.DameTest.saveLoadGameWon<br/>hwr.oop.DameTest.isGameWon                                           |


## Additional Dependencies

[TODO]: # (For each additional dependency your project requires- Add an additional row to the table!)

| Number | Dependency Name | Dependency Description | Why is it necessary? |
|--------|-----------------|------------------------|----------------------|
| 1      | /               | /                      | /                    |

## Instructions
Um das Spiel zu spielen, muss die play_game() Methode im Manuellen Test gestartet werden. Dann wird entsprechend das Spielfeld
angezeigt mit:<br/> 0 - leeres Feld; 1 - weiße Figur; 2 - schwarze Figur<br/>
Spielzüge können vorgenommen werden im Format: X,Y,neuesX,neuesY (Beispiel: "2,2,3,3")<br/>
Import und Export von Spielfeldzuständen erfolgen über die befehle "save" und "load" und einer Eingabe des Dateinamen

