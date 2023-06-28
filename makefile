JAVAC=javac
JAVA=java
JFLAGS = -g
DEL = del /S /Q
CLASSES = AplicacionMatriz.java OperacionesMatrizImpl.java OperacionesMatriz.java PanelMatriz.java Matriz.java
JAVAFX_PATH = C:\Users\nicol\OneDrive\Escritorio\Cosas\javafx-sdk-20.0.1\lib

default: classes

classes: $(CLASSES:.java=.class)

%.class: %.java
	$(JAVAC) --module-path $(JAVAFX_PATH) --add-modules javafx.controls $(JFLAGS) $<

clean:
	$(DEL) *.class

run: classes
	$(JAVA) --module-path $(JAVAFX_PATH) --add-modules javafx.controls AplicacionMatriz

