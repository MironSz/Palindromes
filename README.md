# Palindromes
Znajdowanie palindromów w tekście w czasie O(n)

W pliku Solution.scala znajduje się rozwiązanie, oparte na algorytmie Manachera.
W pliku BrutForceSolution.scala znajduje się rozwiązanie w czasie O(n^2)
Plik Test.scala zawiera program puszczający na wygenerowanych testach programy Solution
i BrutForceSolution.

Rozwiązanie Solution.scala zamiast stosować rekurencję ogonową stosuje zwykłą rekurencję co na dużych testach prowadzi do przepełnienia stosu. Nie umiem znaleźć tego przyczyny. Rozwiązanie w czasie
O(n^2) otrzymuje 100 pkt, gdyż działa w czasie O(m) gdzie m to ilość palindromów na którą jest ograniczenie 10^8.
