import javax.swing.plaf.ColorChooserUI;
import java.io.ByteArrayOutputStream;
import java.io.ObjectOutputStream;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 * Created by anil on 27/02/2017.
 */
public class Main
{
    private static List<List<Foo>> listFoo = new LinkedList<>();
    private static List<List<Order>> listOrders = new LinkedList<>();
    private static List<Order> faultList = new ArrayList<>();
    private final static List<Worker> workerList = new ArrayList<>();
    private List<OrderDB> newListOrders = new ArrayList<>();

    static
    {
        //foo list
        ArrayList<Foo> week1 = new ArrayList<>();
        week1.add( new Foo( 0, 1 ) );
        week1.add( new Foo( 1, 1 ) );
        listFoo.add( week1 );

        ArrayList<Foo> week2 = new ArrayList<>();
        week2.add( new Foo( 0, 2 ) );
        week2.add( new Foo( 1, 2 ) );
        week2.add( new Foo( 2, 2 ) );
        week2.add( new Foo( 3, 2 ) );
        week2.add( new Foo( 4, 2 ) );
        week2.add( new Foo( 5, 2 ) );
        listFoo.add( week2 );

        ArrayList<Foo> week3 = new ArrayList<>();
        week3.add( new Foo( 0, 3 ) );
        week3.add( new Foo( 1, 3 ) );
        week3.add( new Foo( 2, 3 ) );
        week3.add( new Foo( 3, 3 ) );
        listFoo.add( week3 );

        //////////////////////////order list/////////////////////////////////////
        ArrayList<Order> weekOne = new ArrayList<>();
        weekOne.add( new Order( 0, "1/03/2017" ) );
        weekOne.add( new Order( 1, "3/03/2017" ) );
        listOrders.add( weekOne );

        ArrayList<Order> weekTwo = new ArrayList<>();
        weekTwo.add( new Order( 2, "5/03/2017" ) );
        weekTwo.add( new Order( 3, "7/03/2017" ) );
        weekTwo.add( new Order( 4, "9/03/2017" ) );
        weekTwo.add( new Order( 5, "11/03/2017" ) );
        weekTwo.add( new Order( 6, "13/03/2017" ) );
        weekTwo.add( new Order( 7, "15/03/2017" ) );
        listOrders.add( weekTwo );

        ArrayList<Order> weekThree = new ArrayList<>();
        weekThree.add( new Order( 8, "17/03/2017" ) );
        weekThree.add( new Order( 9, "19/03/2017" ) );
        weekThree.add( new Order( 10, "21/03/2017" ) );
        weekThree.add( new Order( 11, "23/03/2017" ) );
        listOrders.add( weekThree );

        /////////////faulty orders /////////////////////
        for (List<Order> listOrder : listOrders) {
            for (Order order : listOrder) {
                if(faultList.size() == 3)
                {
                    break;
                }
                faultList.add(order);
            }
        }

        ////////////workers array//////////////
        workerList.add( new Worker( 0, "Permanent", false ) );
        workerList.add( new Worker( 1, "Permanent", false ) );
        //        workerList.add(new Worker(2,"Contract",false));
        //        workerList.add(new Worker(3,"Contract",false));
        //        workerList.add(new Worker(4,"Contract",false));
    }

    public static void main( String[] args )
    {
        new Main();
        //showMenu();
    }

    public Main()
    {
        CouchDB couchDB = new CouchDB();
        couchDB.showView();
        newListOrders = couchDB.getOrderListFromMaterials();

        //sort the list based on week number of order
        Collections.sort(newListOrders, (p1, p2) -> p1.getWeekNum() - p2.getWeekNum());

        showMenu();
    }

    private void showMenu()
    {
        System.out.println( "----------Menu-------------" );
        System.out.println( "Which role are you?" );
        System.out.println();
        System.out.println( "1. Production Manager" );
        System.out.println( "2. Production Operative" );
        System.out.println( "3. Production Inspector" );
        System.out.println( "4. Show User Guide" );

        Scanner scanner = new Scanner( System.in );

        switch( scanner.nextInt() )
        {
            case 1:
                showManagerMenu();
                switch (scanner.nextInt())
                {
                    case 1:
                        System.out.println("show schedule");
                        createScheduler2();
                        showMenu();
                        break;
                    case 2:
                        System.out.println("show bill of materials");
                        createBill(listFoo);
                        showMenu();
                        break;
                    case 3:
                        System.out.println("show rejection notice");
                        createRejectionNotice(faultList.get(0));
                        showMenu();
                        break;
                    case 4:
                        System.out.println("Going to main menu");
                        showMenu();
                        break;
                }
                break;
            case 2:
                showOperativeMenu();
                showMenu();
                break;
            case 3:
                showInspectorMenu();
                showMenu();
                break;
            case 4:
                userGuide();
                showMenu();
                break;
            default:
                System.out.println( "Not a valid choice" );
        }
    }

    private void userGuide()
    {
        System.out.println("----------------------------User Guide---------------------------");
        System.out.println("Hello and welcome to Production Planning");
        System.out.println("When you access the application you will see a menu like this: \n");

        System.out.println( "----------Menu-------------" );
        System.out.println( "Which role are you?" );
        System.out.println();
        System.out.println( "1. Production Manager" );
        System.out.println( "2. Production Operative" );
        System.out.println( "3. Production Inspector" );
        System.out.println( "----------------------------\n" );

        System.out.println("You choose the option dependant on your job role.");
        System.out.println("In this guide it will be option 1, Production Manager\n");

        System.out.println("As a manager, this sub menu will appear: \n");

        System.out.println( "----------Menu-------------" );
        System.out.println( "1. Show Schedule" );
        System.out.println( "2. Bill Of Materials" );
        System.out.println( "3. Rejection Notice" );
        System.out.println( "4. Go To Main Menu" );
        System.out.println( "----------------------------\n" );

        System.out.println("Here is where you can either: ");
        System.out.println("\tSee the months production schedule");
        System.out.println("\tSee the bill of materials for the order line");
        System.out.println("\tSee the rejection notices for a faulty item");

        System.out.println("\nYou can of course go back to the main menu also");
        System.out.println("----------------------------End Of User Guide---------------------------\n");

    }

    private void showManagerMenu()
    {
        System.out.println( "----------Menu-------------" );
        System.out.println();
        System.out.println( "1. Show Schedule" );
        System.out.println( "2. Bill Of Materials" );
        System.out.println( "3. Rejection Notice" );
        System.out.println( "4. Go To Main Menu" );
    }

    private void showOperativeMenu()
    {
        System.out.println("NOT AN IMPLEMENTED FEATURE\n");
    }

    private void showInspectorMenu()
    {
        System.out.println("NOT AN IMPLEMENTED FEATURE\n");
    }

    private void createBill(List<List<Foo>> listFoo)
    {
        List<Material> materialList = new ArrayList<>();

        List<Quantity> quantityList = new ArrayList<>();
        quantityList.add(new Quantity(Item.BRAKEKIT,1));
        quantityList.add(new Quantity(Item.CARBONCOMPOSITEWHEEL,1));
        quantityList.add(new Quantity(Item.CHAIN,1));
        quantityList.add(new Quantity(Item.DERAILLEURGEARASSEMBLY,1));
        quantityList.add(new Quantity(Item.HEXNUT5MM,1));
        quantityList.add(new Quantity(Item.PACKAGING,1));
        quantityList.add(new Quantity(Item.PEDALASSEMBLY,1));
        quantityList.add(new Quantity(Item.SOCKETHEADBOLT5X20MM,1));
        quantityList.add(new Quantity(Item.TOURINGALUMINIUMWHEEL,1));
        quantityList.add(new Quantity(Item.TOURINGFRAME,1));
        quantityList.add(new Quantity(Item.TOURINGHANDLEBAR,1));
        quantityList.add(new Quantity(Item.TOURINGSEATKIT,1));
        quantityList.add(new Quantity(Item.TOURINGTIRE,1));
        quantityList.add(new Quantity(Item.TOURINGTUBE,1));
        quantityList.add(new Quantity(Item.WARRANTYDOCUMENT,1));

        //materialList.add(new Material(order, Item.BRAKEKIT, 1));
        for (List<Order> orders : listOrders)
        {
            for (Order order : orders)
            {
                //System.out.println(order);
                materialList.add(new Material(order, quantityList));
            }
        }

        for (Material material : materialList)
        {
            System.out.println(material);
        }
    }

    private void createRejectionNotice(Order faultOrder)
    {
        //when an operative finds a fault - needs to be returned/replaced

        //date of inspection
        //item being inspected
        //order number
        //the inspector
        //cause of rejection

        //if there is materials not in stock they are placed under pending until the material is sourced

        Random rand = new Random();
        int randomNum = rand.nextInt(2);

        Inspection inspection = new Inspection("1/03/2017", Item.TOURINGTUBE, faultOrder, workerList.get(randomNum), "dented");

        System.out.println(inspection + "\n");
    }

    private void createScheduler()
    {
        int numOfOrders = 12;
        int weekOneOrders = 2;
        int weekTwoOrders = 6;
        int weekThreeOrders = 4;

        ArrayList<Order> weekOne = new ArrayList<>();
        weekOne.add( new Order( 0, "1/03/2017" ) );
        weekOne.add( new Order( 1, "3/03/2017" ) );

        ArrayList<Order> weekTwo = new ArrayList<>();
        weekTwo.add( new Order( 2, "5/03/2017" ) );
        weekTwo.add( new Order( 3, "7/03/2017" ) );
        weekTwo.add( new Order( 4, "9/03/2017" ) );
        weekTwo.add( new Order( 5, "11/03/2017" ) );
        weekTwo.add( new Order( 6, "13/03/2017" ) );
        weekTwo.add( new Order( 7, "15/03/2017" ) );

        ArrayList<Order> weekThree = new ArrayList<>();
        weekThree.add( new Order( 8, "17/03/2017" ) );
        weekThree.add( new Order( 9, "19/03/2017" ) );
        weekThree.add( new Order( 10, "21/03/2017" ) );
        weekThree.add( new Order( 11, "23/03/2017" ) );

        List<Day> daysList = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DAY_OF_MONTH, 1 );
        int monthMaxDays = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
        //int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);

        int daysOfMonthLeft = monthMaxDays - numOfOrders;

        //week 1
        for (int i = 0; i < weekOneOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 1)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekOne.get(i));
                //date, week, orderarray
                daysList.add(new Day(cal.getTime(), weekNum, tempDayOrders));
                cal.add(Calendar.DATE, 1);
            }

        }

        //skip days to week 2
        for (int i = 0; i < 20; i++)
        {
            int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);
            cal.add(Calendar.DATE, 1);

            if(weekNumber == 2)
            {
                break;
            }
        }

        //week 2
        for (int i = 0; i < weekTwoOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 2)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekTwo.get(0));
                weekTwo.remove(0);
                //date, week, orderarray
                daysList.add(new Day(cal.getTime(), weekNum, tempDayOrders));
                cal.add(Calendar.DATE, 1);
                //System.out.println();
            }
        }

        //skip days to week 3
        for (int i = 0; i < 20; i++)
        {
            int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);
            cal.add(Calendar.DATE, 1);

            if(weekNumber == 3)
            {
                break;
            }
        }

        //week 3
        for (int i = 0; i < weekThreeOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 3)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekThree.get(0));
                weekThree.remove(0);

                daysList.add( new Day( cal.getTime(), weekNum, tempDayOrders ) );
                cal.add( Calendar.DATE, 1 );

            }
        }

        System.out.println("-----------------Schedule--------------");
        System.out.println("Week 1: " + weekOneOrders + " orders");
        System.out.println("Week 2: " + weekTwoOrders + " orders");
        System.out.println("Week 3: " + weekThreeOrders + " orders\n");

        for (Day day : daysList)
        {
            System.out.println(day);
        }
    }

    private void createScheduler2()
    {
        int numOfOrders = 12;
        int weekOneOrders = 3;//2;
        int weekTwoOrders = 6;
        int weekThreeOrders = 3;//4;

        ArrayList<Order> weekOne = new ArrayList<>();
        weekOne.add( new Order( newListOrders.get(0), "1/05/2017" ) );
        weekOne.add( new Order( newListOrders.get(1), "3/05/2017" ) );
        weekOne.add( new Order( newListOrders.get(2), "5/05/2017" ) );

        ArrayList<Order> weekTwo = new ArrayList<>();
        weekTwo.add( new Order( newListOrders.get(3), "7/05/2017" ) );
        weekTwo.add( new Order( newListOrders.get(4), "9/05/2017" ) );
        weekTwo.add( new Order( newListOrders.get(5), "11/05/2017" ) );
        weekTwo.add( new Order( newListOrders.get(6), "13/05/2017" ) );
        weekTwo.add( new Order( newListOrders.get(7), "15/05/2017" ) );
        weekTwo.add( new Order( newListOrders.get(8), "17/05/2017" ) );

        ArrayList<Order> weekThree = new ArrayList<>();

        weekThree.add( new Order( newListOrders.get(9), "19/05/2017" ) );
        weekThree.add( new Order( newListOrders.get(10), "21/05/2017" ) );
        weekThree.add( new Order( newListOrders.get(11), "23/05/2017" ) );

        List<Day> daysList = new ArrayList<>();

        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DAY_OF_MONTH, 1 );
        int monthMaxDays = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
        //int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);

        int daysOfMonthLeft = monthMaxDays - numOfOrders;

        //week 1
        for (int i = 0; i < weekOneOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 1)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekOne.get(i));
                //date, week, orderarray
                daysList.add(new Day(cal.getTime(), weekNum, tempDayOrders));
                cal.add(Calendar.DATE, 1);
            }

        }

        //skip days to week 2
        for (int i = 0; i < 20; i++)
        {
            int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);
            cal.add(Calendar.DATE, 1);

            if(weekNumber == 2)
            {
                break;
            }
        }

        //week 2
        for (int i = 0; i < weekTwoOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 2)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekTwo.get(0));
                weekTwo.remove(0);
                //date, week, orderarray
                daysList.add(new Day(cal.getTime(), weekNum, tempDayOrders));
                cal.add(Calendar.DATE, 1);
                //System.out.println();
            }
        }

        //skip days to week 3
        for (int i = 0; i < 20; i++)
        {
            int weekNumber = cal.get(Calendar.WEEK_OF_MONTH);
            cal.add(Calendar.DATE, 1);

            if(weekNumber == 3)
            {
                break;
            }
        }

        //week 3
        for (int i = 0; i < weekThreeOrders; i++)
        {
            int weekNum = cal.get(Calendar.WEEK_OF_MONTH);
            if(weekNum == 3)
            {
                List<Order> tempDayOrders = new ArrayList<>();
                tempDayOrders.add(weekThree.get(0));
                weekThree.remove(0);

                daysList.add( new Day( cal.getTime(), weekNum, tempDayOrders ) );
                cal.add( Calendar.DATE, 1 );

            }
        }

        System.out.println("-----------------Schedule--------------");
        System.out.println("Week 1: " + weekOneOrders + " orders");
        System.out.println("Week 2: " + weekTwoOrders + " orders");
        System.out.println("Week 3: " + weekThreeOrders + " orders\n");

        for (Day day : daysList)
        {
            System.out.println(day);
        }
    }

    public List<OrderDB> getNewListOrders() {
        return newListOrders;
    }

//Attempt at automated scheduler, almost working
//    private static void createSchedule()
//    {
//        //5 bikes a day
//        //25 a week
//        //100 a month
//
//        Calendar cal = Calendar.getInstance();
//        System.out.println( new SimpleDateFormat( "MMMM" ).format( cal.getTime() ) );
//
//        int monthMaxDays = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
//        System.out.println( monthMaxDays );
//
//        int numOfOrders = 12;
//
//        int weekOne = 5;
//        int weekTwo = 6;
//        int weekThree = 4;
//
//        int count = 0;
//
//        int weekFourArrayIndex = monthMaxDays - 21;
//
//        ArrayList<Integer[]> weekOneList = new ArrayList<>();
//
//        int[] weekFourArray = new int[weekFourArrayIndex];
//
//        Map<String, Integer[]> map = new HashMap<>();
//
//        //max days - 21 = days left for last week of month
//
//        //Generates 10 Random Numbers in the range 1 -20
//        Random rand = new Random();
//
//        ArrayList<Integer> orderNums = new ArrayList<>();
//        orderNums.add( 1 );
//        orderNums.add( 2 );
//        orderNums.add( 3 );
//        orderNums.add( 4 );
//        orderNums.add( 5 );
//        orderNums.add( 6 );
//        orderNums.add( 7 );
//
//        week1: for( int i = 0; count < weekOne; i++ )
//        {
//            if( rand.nextBoolean() )
//            {
//                count++;
//
//                if( count > weekOne )
//                {
//                    //System.out.println("cannot add one");
//                    count--;
//                }
//                else
//                {
//                    weekOneList.add( new Integer[] { orderNums.remove( orderNums.size() - 1 ) } );
//                }
//            }
//            else
//            {
//                count += 2;
//
//                if( count > weekOne )
//                {
//                    //System.out.println("cannot add two");
//                    count -= 2;
//                }
//                else
//                {
//                    weekOneList.add( new Integer[] { orderNums.remove( orderNums.size() - 1 ),
//                            orderNums.remove( orderNums.size() - 1 ) } );
//                }
//            }
//        }
//
//        for( Integer[] integers : weekOneList )
//        {
//            if( integers.length > 1 )
//            {
//                System.out.println( "week-1 : " + integers[0] + " - " + integers[1] );
//            }
//            else
//            {
//                System.out.println( "week-1 : " + integers[0] );
//            }
//        }
//
//        //createCalender(weekOneList);
//    }
//
//    public static void createCal()
//    {
//        SimpleDateFormat sdf = new SimpleDateFormat( "dd/MM/yyyy" );
//        Calendar cal = Calendar.getInstance();
//        cal.set( Calendar.DAY_OF_MONTH, 1 );
//
//        int numOfOrders = 13;
//        int weekOneOrders = 3;
//        int weekTwoOrders = 6;
//        int weekThreeOrders = 4;
//
//        List<Order> orderList = new ArrayList<>();
//
//        //list of orders with id and latest start date
//        for( int i = 0; i < numOfOrders; i++ )
//        {
//            orderList.add( new Order( i, "2/03/2017" ) );
//            cal.add( Calendar.DATE, 2 );
//        }
//
//        workerList.add( new Worker( 0, "Permanent", false ) );
//        workerList.add( new Worker( 1, "Permanent", false ) );
//        //        workerList.add(new Worker(2,"Contract",false));
//        //        workerList.add(new Worker(3,"Contract",false));
//        //        workerList.add(new Worker(4,"Contract",false));
//
//        //create calender for the month
//        Calendar calendar = Calendar.getInstance();
//        int monthMaxDays = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
//
//        List<List<Day>> scheduleList = new ArrayList<>();
//        List<Day> week1 = new ArrayList<>();
//        List<Day> week2 = new ArrayList<>();
//        List<Day> week3 = new ArrayList<>();
//        List<Day> week4 = new ArrayList<>();
//        List<Day> restOfWeek = new ArrayList<>();
//
//
//        for( int i = 1; i <= monthMaxDays; i++ )
//        {
//            calendar.set( Calendar.DAY_OF_MONTH, i );
//            int weekNum = calendar.get( Calendar.WEEK_OF_MONTH );
//            int dayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
//
//            Map<Order, Integer> tempWeekOrders = new LinkedHashMap<>();
//
//            if( weekNum == 1 )
//            {
//                //bikesToWork //tempWeekOrders.size()
//                //operatives //workerList.size()
//
//                int count = 0;
//                int tempSize = tempWeekOrders.size();
//                int workerSize = workerList.size();
//                int arraySize = 0;
//                Order[] orders = null;
//
//                if( tempWeekOrders.size() >= workerList.size() ) //orders more than workers
//                {
//                    //if more orders than workers
//                    //create order array with enough orders for the workers to handle such as 2 orders for 2 workers
//
//
//                   // week1.add( new Day( calendar.getTime(), 1, orders ) );
//                }
//
//                if( tempWeekOrders.size() < workerList.size() )
//                {
//                    //if there are less orders than people such as 1 order for 2 workers then
//                    // add the extra order to its own order array
//
//
//                   // week1.add( new Day( calendar.getTime(), 1, orders ) );
//                }
//
//                //week1.add(new Day(calendar.getTime(), 1, orders));
//
//
//                //                    else
//                //                    {
//                //                        orders = new Order[tempSize];
//                //
//                //                        secondInner:
//                //                        for (int i1 = 0; i1 < tempSize; i1++)
//                //                        {
//                //                            innerLoop:
//                //                            for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); ) {
//                //                                Map.Entry<Order, Integer> tempMap = order.next();
//                //                                Order key = tempMap.getKey();
//                //
//                //                                orders[i1] = key;
//                //                                order.remove(); //remove order
//                //                                break secondInner;
//                //
//                //                            }
//                //                        }
//                //                    }
//                //                    week1.add(new Day(calendar.getTime(), 1, orders));
//                //orders = null;
//                //                }
//                //                else if(tempWeekOrders.size() < workerList.size()) //bikesOrders < workers
//                //                {
//                //                    //more than needed workers so just add amount of bikes left to the day
//                //                    //amount of tempWeekOrders add all to this day
//                //
//                //                    final int tempSize = tempWeekOrders.size();
//                //                    final int workerSize = workerList.size();
//                //                    Order[] orders = new Order[tempSize];
//                //                    //set number of orders to amount of workers for that day
//                //                    //loop through week 1 orders
//                //
//                //                    for (int i1 = 0; i1 < tempSize; i1++)
//                //                    {
//                //                        innerLoop:
//                //                        for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); )
//                //                        {
//                //                            Map.Entry<Order, Integer> tempMap = order.next();
//                //                            Order key = tempMap.getKey();
//                //
//                //                            orders[i1] = key;
//                //                            order.remove(); //remove order
//                //                            break innerLoop;
//                //
//                //                        }
//                //                    }
//                //                    week1.add(new Day(calendar.getTime(), 1, orders));
//                //                    orders = null;
//                //                }
//
//                //week1.add(new Day(calendar.getTime(), 1 ));
//
//                //bikes - operatives, set bikes to be worked on the day to the amount of operatives available
//                //loop through adding days until no more bikes to work
//
//                //if bikes to be worked < the number of workers
//                //set the day to have the bikes to be worked value not the operatives
//            }
//            else if( weekNum == 2 )
//            {
//                week2.add( new Day( calendar.getTime(), 2 ) );
//            }
//            else if( weekNum == 3 )
//            {
//                week3.add( new Day( calendar.getTime(), 3 ) );
//            }
//            else if( weekNum == 4 )
//            {
//                week4.add( new Day( calendar.getTime(), 4 ) );
//            }
//            else
//            {
//                restOfWeek.add( new Day( calendar.getTime(), 5 ) );
//            }
//
//            //dayList.add(new Day(calendar.getTime(), weekNum, new Worker[] {workerList.get(0),workerList.get(1)} ));
//            //dayList.add(new Day(calendar.getTime(), weekNum ));
//        }
//
//        //add all weeks to one total list
//        scheduleList.add( week1 );
//        scheduleList.add( week2 );
//        scheduleList.add( week3 );
//        scheduleList.add( week4 );
//        scheduleList.add( restOfWeek );
//
//        for( List<Day> days : scheduleList )
//        {
//            for( Day day : days )
//            {
//                something( day );
//            }
//        }
//
//
//        for( List<Day> days : scheduleList )
//        {
//            assignBikesToOperators( days );
//        }
//    }
//
//    private static List<Foo> fooCopy = new ArrayList<>();
//
//
//    private static void assignBikesToOperators( List<Day> days )
//    {
//        int bikes = 0;
//        int operators = workerList.size();
//        Date lastDay = null;
//
//        for( int i = 0; i < days.size(); i++ )
//        {
//            final Day day = days.get( i );
//
//            if( !day.getDate().equals( lastDay ) ) {
//                if (bikes == 0) {
//                    // bikes = days.get( i ).getFoo().size();
//                }
//
//                if (fooCopy.size() > 0) {
//                    // day.setFoo( fooCopy );
//                }
///*
//                //if(// day.getFoo().size() != 0 )
//                {
//                    if( day.getWeekNum() == day.getFoo().get( fooCopy.size() != bikes ? i : i-- ).getWeek() )
//                    {
//                        if( day.getFoo().size() != 0 )
//                        {
//                            if( bikes < operators )
//                            {
//                                List<Foo> newList = new ArrayList<>();
//
//                                for( int i1 = 0; i1 < bikes; i1++ )
//                                {
//                                    newList.add( day.getFoo().get( i1 ) );
//                                }
//
//                                day.setFoo( newList );
//                            }
//
//                            if( bikes > operators )
//                            {
//                                fooCopy = day.getFoo();
//                            }
//
//                            List<Foo> blah = new ArrayList<>();
//
//                            for( int i1 = 0; i1 < operators; i1++ )
//                            {
//                                if( day.getFoo().size() <= 1 )
//                                {
//                                    blah.add( day.getFoo().get( 0 ) );
//                                    fooCopy.remove( day.getFoo().get( 0 ) );
//                                    break;
//                                }
//                                blah.add( day.getFoo().get( i1 ) );
//                                fooCopy.remove( day.getFoo().get( i1 ) );
//                            }
//
//                            day.setFoo( blah );
//                            bikes = bikes - day.getFoo().size();
//                        }
//                    }
//                }
//
//                lastDay = day.getDate();
//                System.out.println( day );
//            }*/
//            }
//        }
//    }
//
//
//    private static byte[] createClone( Day day ) throws Exception
//    {
//        ByteArrayOutputStream bos = new ByteArrayOutputStream();
//        ObjectOutputStream oos = new ObjectOutputStream( bos );
//        oos.writeObject( day );
//        oos.flush();
//        oos.close();
//        bos.close();
//
//        return bos.toByteArray();
//    }
//
//
//    private static void something( final Day day )
//    {
//        for( Iterator<List<Foo>> iterator = listFoo.iterator(); iterator.hasNext(); )
//        {
//            final List<Foo> element = iterator.next();
//            List<Foo> fooList = new ArrayList<>();
//
//            for( int i = 0; i < element.size(); i++ )
//            {
//                if( element.get( i ).getWeek() == day.getWeekNum() )
//                {
//                    fooList.add( element.get( i ) );
//                }
//                else if( element.get( i ).getWeek() == day.getWeekNum() )
//                {
//                    fooList.add( element.get( i ) );
//                }
//                else if( element.get( i ).getWeek() == day.getWeekNum() )
//                {
//                    fooList.add( element.get( i ) );
//                }
//                else if( element.get( i ).getWeek() == day.getWeekNum() )
//                {
//                    fooList.add( element.get( i ) );
//                }
//                else if( element.get( i ).getWeek() == day.getWeekNum() )
//                {
//                    fooList.add( element.get( i ) );
//                }
//            }
//
//            //day.setFoo( fooList );
//            if( fooList.size() == element.size() )
//            {
//                iterator.remove();
//            }
//            break;
//        }
//    }
//
//
//    public static void createCalender( ArrayList<Integer[]> weekOneList )
//    {
//        List<Day> dayList = new ArrayList<>();
//        List<Job> jobsList = new ArrayList<>();
//
//        //create calender for the month
//        Calendar calendar = Calendar.getInstance();
//        int monthMaxDays = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );
//
//        //transfer integer array to job objects //jobs are just groups of orders only used for assigning orders to days
//        for( Integer[] integers : weekOneList )
//        {
//            if( integers.length > 1 )
//            {
//                //jobsList.add( new Job( new Order[] { new Order( integers[0], calendar.getTime() ),
//                        //new Order( integers[1], calendar.getTime() ) } ) );
//            }
//            else
//            {
//                //jobsList.add( new Job( new Order[] { new Order( integers[0], calendar.getTime() ) } ) );
//            }
//
//        }
//
//        for( int i = 1; i <= monthMaxDays; i++ )
//        {
//            calendar.set( Calendar.DAY_OF_MONTH, i );
//            int weekNum = calendar.get( Calendar.WEEK_OF_MONTH );
//            int dayOfWeek = calendar.get( Calendar.DAY_OF_WEEK );
//            //System.out.println(dayOfWeek);
//
//            if( jobsList.size() > 0 )
//            {
//                inner: for( Job job : jobsList )
//                {
//                    //if weekend dont add orders
//                    if( dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY )
//                    {
//                        dayList.add( new Day( calendar.getTime(), weekNum ) );
//                        break;
//                    }
//                    else
//                    {
//                        //dayList.add( new Day( calendar.getTime(), job.getJobs(), weekNum ) );
//                        jobsList.remove( job );
//                        break;
//                    }
//                }
//            }
//            else
//            {
//                dayList.add( new Day( calendar.getTime(), weekNum ) );
//            }
//        }
//
//        for( Day day : dayList )
//        {
//            System.out.println( day.toString() );
//        }
//    }
}