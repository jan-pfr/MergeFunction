Merge Intervals
===============

Task
-----
Die Aufgabe war es, eine Funktion zu implementieren, die eine Liste von Intervallen als Parameter entgegennimmt und eine Liste von Intervallen auch wieder zurückgibt. Intervalle, die sich überschneiden oder in dem jeweils anderen komplett enthalten sind, werden zusammengeführt. Nicht überschneidende Intervalle bleiben unberührt. 

Lösungsansatz
-------------
Um die Intervalle später in einer Zeitkomplexität von `O(n)` zusammenzufassen zu können, wurden die Intervalle, aufsteigend nach dem Start der Intervalle, sortiert.
Dafür wurde der Mergesort Algortihmus ausgewählt. Dieser hat eine Zeitkomplexität von `O(n log (n))`. Die Zeitkomplexität ist dabei gleichbleibend, unabhängig vom besten, durchschnittlichen oder schlechtesten Fall. Über die Liste der sortierten Intervalle wird anschließend einmal iterriert. Dabei wird ein Intervall direkt in ein `ArrayBuffer` geschrieben, wenn der `ArrayBuffer` leer ist oder das Intervall sich mit dem letzten Intervall aus dem `ArrayBuffer` nicht überschneidet. Überschneidet sich das Intervall mit dem letzten Intervall aus dem `ArrayBuffer`, wird ein neues, zusammengefügtes Intervall erstellt, das zuletzt hinzugefügte Intervall gelöscht und das neue Intervall an das Ende des `ArrayBuffer` angehängt.
Zuletzt wird der `ArrayBuffer` als Array zurückgegeben. 

Der Einsatz von einem Mergesort und die Zusammenfassung der Intervalle ergeben eine Zeitkomplexität von `O(n log (n))`. Gerade bei großen Eingaben sorgt dies dafür, dass die Verarbeitung zeitlich nicht eskaliert. Der Algorithmus braucht dafür mehr Speicher, da die Zwischenergebnisse immer wieder gespeichert werden müssen. Zusätzliche Robustheit wird durch eine Eingabe-Validierung sichergestellt. 

Bearbeitungsdauer: 10.5 Stunden

Genutzte Versionen
----------------
Scala Version: `3.1.2` \
sbt Version:  `1.6.2`