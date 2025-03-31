## first

table of english letter p
letter group

0. 0.12 E
1. 0.006 0.009 TAOINSHR
2. 0.04 DL
3. 
4. 0.01 VKJXQZ

bigrams/trigrams th he in en nt re er an ti es on

k = (7, 3)
e_k (o) = e_k(14) = 7 * 14 + 3 mod 26 = 23

affine: 
e_k(alpha) = a * alpha + b mod 26
d_k(alpha) = a^(-1)(alpha - b) mod 26

7 * z congruent 1 mod 26
7^(-1) = 15

15 * -3 mod 26 = -45 mod 26 = 26 * 3 - 45

<br> brute force

312 keys: k_1, ..., k_312
decriptez cu fiecare pe rand - textul rezultat are sens? if yes => return

punct de unicitate - english alphabet = 7

- putem folosi pentru un sistem afin functii polinomiale de grad 2 si nu liniare?
- spatiu de chei mai mare
- dar pentru acelasi text criptat exista mai multe decriptari

TEMA: investigati criptarea cu functii polinomiale patratice

- message-recory solution - cand un adversar care nu afla neaparat cheia dar afla mesajul

<br> scurgere de informatii

- vezi table cu probabilitati of english letters
- vezi table cu frecvente of letters of the stolen message
- faci sinapse

<br>

- criptarea probabilista:
- premiul turing criptezi o litera in mai multe feluri 
=> criptare moderna

a trebuie sa fie coprim cu 26, daca nu inseamna ca scurgerea de informatii nu a functionat

<br> 

4a + b congruent 5 mod 26
7a + b congruent 9 mod 26

7a + 5 - 4a congruent 9 mod 26

<br>

e_k(e) = r <=> e_k(4) = 17
e_k(a) = d <=> e_k(0) = 3

4a + b congruent 17 mod 26
b congruent 3 mod 26

b = 3
4a congruent 14 mod 26
4 nu este coprim cu 26 si nu este bun

<br>

e_k(o) = d <=> e_k(14) = 3

4a + b congruent 17 mod 26
14a + b congruent 3 mod 26


14a + 17 - 4a congruent 3 mod 26
10a + 17 congruent 3 mod 26
10 nu este coprim cu 26 si nu este bun

- confuzie si difuzie

## kasiski

- find the most freq letter
- find its pos
- find the distances between them
- find divizors of them => length key
- 1 and 2 are not probable

## vigenere

- find probability of letter
- IC = probability of finding the same letter twice in text

decode.fr => calculates IC
polyalphabetic = o litera se poate cripta in mai multe litere

daca IC (>0.6) este mare shiftare, monoalphabetic, substitution

IC => lungimea cheii - cea mai mare valoare - lungimea cheie buna


pentru MIC(x, y)
x, y texte in limbaje naturale

<br>

pentru y_i caut valoarea shiftului
oricare j din 0 pana la 25, calculam M

aleg acel j pentru care M este maxim
j = val shift
