# ACT07_Menu_Llista_filtre

## Documentació

### Introducció
En aquesta activitat s’han implementat dos **RecyclerView** per mostrar les llistes d’elements.  
L’objectiu és entendre el funcionament del patró **Adapter + ViewHolder**, la separació de responsabilitats dins del codi i la implementació de **filtres** per modificar la informació que es mostra a la llista.

## Què és un RecyclerView?

Un **RecyclerView** és un component que permet mostrar llistes o graelles d’elements de manera eficient.  
La seva principal característica és que **recicla les vistes** que ja no són visibles, evitant crear-ne de noves constantment i millorant el rendiment de l’aplicació.

Per utilitzar un RecyclerView cal:
- Una llista de dades (en memòria).
- Un layout XML per a la pantalla que conté el RecyclerView.
- Un layout XML per a cada fila.
- Un Adapter i un ViewHolder.

---

## Model de dades i font de dades

## Data class
Per representar cada element de la llista s’ha creat una `data class`:

![alt text](img/image.png)

*Aquesta classe defineix la informació que es mostrarà a cada fila del RecyclerView.*

## Font de dades en memòria (object)

Les dades es guarden en un `object` de Kotlin que actua com un Singleton:

![alt text](img/image2.png)

*Aquest objecte permet tenir una única instància de dades durant l'execució i accedir a la mateixa llista des de diferents pantalles.*

## Layout de cada element
Cada fila del RecyclerView es defineix en un layout XML independent:

![alt text](img/image3.png)
*Aquest layout defineix l'aspecte visual d'un sol element de la llista.*

## ViewHolder
El ViewHolder encapsula la vista d’una fila del RecyclerView i conté la lògica necessària per mostrar-hi les dades corresponents. En aquest projecte, el ViewHolder només gestiona un `TextView`, que mostra el títol de cada element.

![alt text](img/image4.png)

*Aquest ViewHolder rep la vista de la fila `itemView` i busca una sola vegada les referències a les seves sub-vistes, en aquest cas el `TextView`. El mètode `bind` és el punt central on s’assignen les dades de l’objecte `MyItem` a la interfície. També és aquí on es configura el listener de clic, que notifica quin element i quina posició s’ha seleccionat. D’aquesta manera, tota la lògica relacionada amb una fila concreta queda encapsulada dins del ViewHolder.*

## Adapter
L’Adapter actua com a intermediari entre la llista de dades i el RecyclerView. En aquest projecte, l’Adapter manté dues llistes: una amb totes les dades originals i una altra amb les dades filtrades que realment es mostren a la pantalla.

![alt text](img/image5.png)

*L’Adapter s’encarrega de crear els ViewHolder inflant el layout XML de cada fila, d’indicar al RecyclerView quants elements ha de mostrar i de passar les dades corresponents a cada posició. Quan el RecyclerView necessita mostrar una fila, l’Adapter crida el mètode `bind` del ViewHolder, passant-li l’element correcte de la llista filtrada. Aquesta separació permet que l’Adapter no s’hagi de preocupar de com es mostren exactament les dades, sinó només de gestionar-les i proporcionar-les al ViewHolder. A més, el fet de treballar amb una llista filtrada independent permet implementar filtres sense perdre la llista original, facilitant que l’usuari pugui canviar entre diferents vistes de les dades de manera senzilla.*



