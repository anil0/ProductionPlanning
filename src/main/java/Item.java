/**
 * Created by anil on 27/02/2017.
 */
public enum Item
{

    BRAKEKIT("Brake Kit"),
    CARBONCOMPOSITEWHEEL("Carbon Composite Wheel"),
    CHAIN("Chain"),
    DERAILLEURGEARASSEMBLY("Derailleur Gear Assembly"),
    HEXNUT5MM("Hex Nut 5mm"),
    PACKAGING("Packaging"),
    PEDALASSEMBLY("Pedal Assembly"),
    SOCKETHEADBOLT5X20MM("Socket Head Bolt 5x20mm"),
    TOURINGALUMINIUMWHEEL("Touring Aluminium Wheel"),
    TOURINGFRAME("Touring Frame"),
    TOURINGHANDLEBAR("Touring Handle Bar"),
    TOURINGSEATKIT("Touring Seat Kit"),
    TOURINGTIRE("Touring Tire"),
    TOURINGTUBE("Touring Tube"),
    WARRANTYDOCUMENT("Warranty Document");

    private String itemName;

    Item(String itemName) {
        this.itemName = itemName;
    }

    public String getItemName() {
        return itemName;
    }
}
