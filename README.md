Merge Intervals
===============

Task
-----
Die Aufgabe war es, eine Funktion zu implementieren, die eine Liste von Intervallen als Parameter entgegennimmt und eine Liste von Intervallen auch wieder zurückgibt. Intervalle, die sich überschneiden oder in dem jeweils anderen komplett enthalten sind, werden zusammengeführt. Nicht überscheidende Intervall bleiben unberührt. 

Lösungsansatz
-------------
Um die Intervalle später in einer Zeitkomplexität von `O(n)` zusammenzufassen zu können, werden die Intervalle, aufsteigend nach dem Start der Intervalle, sortiert.
Dafür wurde der MergeSort Algortihmus ausgewählt. Dieser hat eine Zeitkomplexität von `O(n log (n))`. Die Zeitkomplexität ist dabei unveränderlich, unabhängig vom besten, durchschnittlichen oder schlechtesten Fall. Über die Liste der sortierten Intervalle wird einmal iterriert. Dabei wird ein Intervall direkt in ein `ArrayBuffer` geschrieben, wenn der `ArrayBuffer` leer ist oder das Intervall sich mit dem letzten Interval aus dem `ArrayBuffer` nicht überschneidet. Überschneidet sich das Intervall mit dem letzten Intervall aus dem `ArrayBuffer`, wird ein neues Intervall erstellt, der zuletzt hinzugefügte gelöscht und das neue Intervall an das Ende des `ArrayBuffer` angehängt.
Zuletzt wird der `ArrayBuffer` als Array zurückgegeben. 

Der Einsatz von einem Mergesort und die Zusammenfassung der Intervalle ergeben eine Zeitkomplexität von `O(n log (n))`. Gerade bei großen Eingaben sorgt dies dafür, dass die Verarbeitung zeitlich nicht eskaliert. Der Algorithmus braucht dafür mehr Speicher, da die Zwischenergebnisse immer wieder zwischengespeichert werden müssen. Mehr Robustheit, unabhängig von der Größer der Eingabe, ist zudem durch die Eingabe-Validierung gegeben. 

Bearbeitungsdauer: 10.5 Stunden

Technische Daten
----------------
Scala: `3.1.2` \
sbt:  `1.6.2`