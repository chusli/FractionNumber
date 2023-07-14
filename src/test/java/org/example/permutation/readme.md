# PERMUTATION KATA

Diese selbsterfundene Kata hat 2 Ziele:

1. Right BICEP erklären
2. mein Wunsch einer generischen Permutation Klasse zu entwickeln

Motivation ist ein Problem aus dem Alltag: Eine Liste von Objekten
muss den Anforderungen entsprechend sortiert werden.
Die Sortierung sollte natürlich unabhängig vom Input immer gleich funktionieren.
Deshalb möchte ich auf einfache Weise den Input permutieren und prüfen, das der Outut gleich bleibt.

## Anforderungen:

- Eingabe ist eine generische Liste von Objekten des Types "T"
- Ausgabe ist eine Liste von allen Permutationen der Eingabe

## Beispiele

Eingabe: `[1]`  
Ausgabe: `[1]`

Eingabe: `[1,2]`  
Ausgabe: `[[1,2],[2,1]]`

Eingabe: `[1,2,3]`  
Ausgabe: `[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]`