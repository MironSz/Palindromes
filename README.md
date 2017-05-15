# Palindromes
Znajdowanie palindromów w tekście w czasie O(n)

W pliku Solution.scala znajduje się rozwiązanie, oparte na algorytmie Manachera.
W pliku BrutForceSolution.scala znajduje się rozwiązanie w czasie O(n^2)
Plik Test.scala zawiera program puszczający na wygenerowanych testach programy Solution
i BrutForceSolution.

Na codility jest ustawiony względnie mały limit na stos, przez co
im bardziej funkcyjne rozwiązanie tym na mniejszą ilość punktów wchodzi. Rozwiązanie w czasie
O(n^2) otrzymuje 100 pkt, gdyż działa w czasie O(m) gdzie m to ilość palindromów na którą jest ograniczenie 10^8.
