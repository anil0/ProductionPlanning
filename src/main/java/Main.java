import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
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
    public static void main( String[] args )
    {

        showMenu();

        Scanner scanner = new Scanner( System.in );

        switch( scanner.nextInt() )
        {
            case 1:
                //createSchedule();
                createCal();
                break;
            default:
                System.out.println( "Not a valid choice" );
        }
    }


    private static void createSchedule()
    {
        //5 bikes a day
        //25 a week
        //100 a month

        Calendar cal = Calendar.getInstance();
        System.out.println( new SimpleDateFormat( "MMMM" ).format( cal.getTime() ) );

        int monthMaxDays = cal.getActualMaximum( Calendar.DAY_OF_MONTH );
        System.out.println( monthMaxDays );

        int numOfOrders = 12;

        int weekOne = 5;
        int weekTwo = 6;
        int weekThree = 4;

        int count = 0;

        int weekFourArrayIndex = monthMaxDays - 21;

        ArrayList<Integer[]> weekOneList = new ArrayList<>();

        int[] weekFourArray = new int[weekFourArrayIndex];

        Map<String, Integer[]> map = new HashMap<>();

        //max days - 21 = days left for last week of month

        //Generates 10 Random Numbers in the range 1 -20
        Random rand = new Random();

        ArrayList<Integer> orderNums = new ArrayList<>();
        orderNums.add( 1 );
        orderNums.add( 2 );
        orderNums.add( 3 );
        orderNums.add( 4 );
        orderNums.add( 5 );
        orderNums.add( 6 );
        orderNums.add( 7 );

        week1: for( int i = 0; count < weekOne; i++ )
        {
            if( rand.nextBoolean() )
            {
                count++;

                if( count > weekOne )
                {
                    //System.out.println("cannot add one");
                    count--;
                }
                else
                {
                    weekOneList.add( new Integer[] { orderNums.remove( orderNums.size() - 1 ) } );
                }
            }
            else
            {
                count += 2;

                if( count > weekOne )
                {
                    //System.out.println("cannot add two");
                    count -= 2;
                }
                else
                {
                    weekOneList.add( new Integer[] { orderNums.remove( orderNums.size() - 1 ),
                            orderNums.remove( orderNums.size() - 1 ) } );
                }
            }
        }

        for( Integer[] integers : weekOneList )
        {
            if( integers.length > 1 )
            {
                System.out.println( "week-1 : " + integers[0] + " - " + integers[1] );
            }
            else
            {
                System.out.println( "week-1 : " + integers[0] );
            }
        }

        //createCalender(weekOneList);
    }


    private static void showMenu()
    {
        System.out.println( "----------Menu-------------" );
        System.out.println( "1. Show Schedule" );
    }


    private static List<List<Foo>> listFoo = new LinkedList<>();
    static
    {
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
        week3.add( new Foo( 0, 3) );
        week3.add( new Foo( 1, 3 ) );
        week3.add( new Foo( 2, 3 ) );
        week3.add( new Foo( 3, 3 ) );
        listFoo.add( week3 );
    }

    private final static List<Worker> workerList = new ArrayList<>();


    public static void createCal() {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.DAY_OF_MONTH, 1);

        int numOfOrders = 13;
        int weekOneOrders = 3;
        int weekTwoOrders = 6;
        int weekThreeOrders = 4;

        List<Order> orderList = new ArrayList<>();

        //list of orders with id and latest start date
        for (int i = 0; i < numOfOrders; i++) {
            orderList.add(new Order(i, cal.getTime()));
            cal.add(Calendar.DATE, 2);
        }

        workerList.add(new Worker(0, "Permanent", false));
        workerList.add(new Worker(1, "Permanent", false));
//        workerList.add(new Worker(2,"Contract",false));
//        workerList.add(new Worker(3,"Contract",false));
//        workerList.add(new Worker(4,"Contract",false));

        //create calender for the month
        Calendar calendar = Calendar.getInstance();
        int monthMaxDays = calendar.getActualMaximum(Calendar.DAY_OF_MONTH);

        List<List<Day>> scheduleList = new ArrayList<>();
        List<Day> week1 = new ArrayList<>();
        List<Day> week2 = new ArrayList<>();
        List<Day> week3 = new ArrayList<>();
        List<Day> week4 = new ArrayList<>();
        List<Day> restOfWeek = new ArrayList<>();


        for (int i = 1; i <= monthMaxDays; i++) {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            int weekNum = calendar.get(Calendar.WEEK_OF_MONTH);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            Map<Order, Integer> tempWeekOrders = new LinkedHashMap<>();

            if (weekNum == 1) {
                //bikesToWork //tempWeekOrders.size()
                //operatives //workerList.size()

                int count = 0;
                int tempSize = tempWeekOrders.size();
                int workerSize = workerList.size();
                int arraySize = 0;
                Order[] orders = null;

                if (tempWeekOrders.size() >= workerList.size()) //orders more than workers
                {
                    //if more orders than workers
                    //create order array with enough orders for the workers to handle such as 2 orders for 2 workers


                    week1.add(new Day(calendar.getTime(), 1, orders));
                }

                if (tempWeekOrders.size() < workerList.size()) {
                    //if there are less orders than people such as 1 order for 2 workers then
                    // add the extra order to its own order array


                    week1.add(new Day(calendar.getTime(), 1, orders));
                }

                //week1.add(new Day(calendar.getTime(), 1, orders));


//                    else
//                    {
//                        orders = new Order[tempSize];
//
//                        secondInner:
//                        for (int i1 = 0; i1 < tempSize; i1++)
//                        {
//                            innerLoop:
//                            for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); ) {
//                                Map.Entry<Order, Integer> tempMap = order.next();
//                                Order key = tempMap.getKey();
//
//                                orders[i1] = key;
//                                order.remove(); //remove order
//                                break secondInner;
//
//                            }
//                        }
//                    }
//                    week1.add(new Day(calendar.getTime(), 1, orders));
                //orders = null;
//                }
//                else if(tempWeekOrders.size() < workerList.size()) //bikesOrders < workers
//                {
//                    //more than needed workers so just add amount of bikes left to the day
//                    //amount of tempWeekOrders add all to this day
//
//                    final int tempSize = tempWeekOrders.size();
//                    final int workerSize = workerList.size();
//                    Order[] orders = new Order[tempSize];
//                    //set number of orders to amount of workers for that day
//                    //loop through week 1 orders
//
//                    for (int i1 = 0; i1 < tempSize; i1++)
//                    {
//                        innerLoop:
//                        for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); )
//                        {
//                            Map.Entry<Order, Integer> tempMap = order.next();
//                            Order key = tempMap.getKey();
//
//                            orders[i1] = key;
//                            order.remove(); //remove order
//                            break innerLoop;
//
//                        }
//                    }
//                    week1.add(new Day(calendar.getTime(), 1, orders));
//                    orders = null;
//                }

                //week1.add(new Day(calendar.getTime(), 1 ));

                //bikes - operatives, set bikes to be worked on the day to the amount of operatives available
                //loop through adding days until no more bikes to work

                //if bikes to be worked < the number of workers
                //set the day to have the bikes to be worked value not the operatives
            } else if (weekNum == 2) {
                week2.add(new Day(calendar.getTime(), 2));
            } else if (weekNum == 3) {
                week3.add(new Day(calendar.getTime(), 3));
            } else if (weekNum == 4) {
                week4.add(new Day(calendar.getTime(), 4));
            } else {
                restOfWeek.add(new Day(calendar.getTime(), 5));
            }

            //dayList.add(new Day(calendar.getTime(), weekNum, new Worker[] {workerList.get(0),workerList.get(1)} ));
            //dayList.add(new Day(calendar.getTime(), weekNum ));
        }

        //add all weeks to one total list
        scheduleList.add(week1);
        scheduleList.add(week2);
        scheduleList.add(week3);
        scheduleList.add(week4);
        scheduleList.add(restOfWeek);

        for (List<Day> days : scheduleList)
        {
            for (Day day : days)
            {
                something( day );
            }
        }


        for( List<Day> days : scheduleList )
        {
            assignBikesToOperators( days );
        }
    }


    private static void assignBikesToOperators( List<Day> days )
    {
        int bikes = 0;
        int operators = workerList.size();

        for ( int i = 0; i < days.size(); i++ )
        {
            if( bikes == 0 )
            {
                bikes = days.get( i ).getFoo().size();
            }

            final Day day = days.get( i );

            if( day.getFoo().size() != 0 )
            {
                if( day.getWeekNum() == day.getFoo().get( i ).getWeek() )
                {
                    if( day.getFoo().size() != 0 )
                    {
                        if( bikes < operators )
                        {
                            List<Foo> newList = new ArrayList<>();

                            for (int i1 = 0; i1 < bikes; i1++)
                            {
                                newList.add( day.getFoo().get( i1 ) );
                            }

                            //day.setFoo(  );
                        }
                    }
                }


//                for (int i = 0; i < day.getFoo().size(); i++)
//                {
//                    if (bikes != 0)
//                    {
//                        if (bikes < operators)
//                        {
//                            List<Foo> a = new ArrayList<>();
//                            for (int i1 = 0; i1 < bikes; i1++)
//                            {
//                                a.add(day.getFoo().get(i));
//                            }
//
//                            day.setFoo(a);
//                            break;
//                        }
//
//                        for (int i1 = 0; i1 < bikes; i1++)
//                        {
//                            b.add(day.getFoo().get(i1));
//                        }
//
//                        for (int i1 = operators; i1 < b.size(); i1 = operators)
//                        {
//                            break;
//                        }
//
//                        bikes = bikes - day.getFoo().size();
//                        break;
//                    }
//                }
            }

            //System.out.println( day );
        }
    }

    private static void something( final Day day )
    {
        for (Iterator<List<Foo>> iterator = listFoo.iterator(); iterator.hasNext(); )
        {
            final List<Foo> element = iterator.next();
            List<Foo> fooList = new ArrayList<>();

            for (int i = 0; i < element.size(); i++)
            {
                if (element.get(i).getWeek() == day.getWeekNum())
                {
                    fooList.add(element.get(i));
                }
                else if (element.get(i).getWeek() == day.getWeekNum())
                {
                    fooList.add(element.get(i));
                }
                else if (element.get(i).getWeek() == day.getWeekNum())
                {
                    fooList.add(element.get(i));
                }
                else if (element.get(i).getWeek() == day.getWeekNum())
                {
                    fooList.add(element.get(i));
                }
                else if( element.get( i ).getWeek() == day.getWeekNum() )
                {
                    fooList.add(element.get(i));
                }
            }

            day.setFoo(fooList);
            if( fooList.size() == element.size() )
            {
                iterator.remove();
            }
            break;
        }
    }





















    public static void createCalender(ArrayList<Integer[]> weekOneList)
    {
        List<Day> dayList = new ArrayList<>();
        List<Job> jobsList = new ArrayList<>();

        //create calender for the month
        Calendar calendar = Calendar.getInstance();
        int monthMaxDays = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );

        //transfer integer array to job objects //jobs are just groups of orders only used for assigning orders to days
        for (Integer[] integers : weekOneList)
        {
            if(integers.length > 1)
            {
                jobsList.add( new Job(new Order[] { new Order(integers[0], calendar.getTime()), new Order(integers[1], calendar.getTime()) } ) );
            }
            else
            {
                jobsList.add( new Job(new Order[] { new Order(integers[0], calendar.getTime()) } ) );
            }

        }

        for( int i = 1; i <= monthMaxDays; i++ )
        {
            calendar.set( Calendar.DAY_OF_MONTH, i );
            int weekNum = calendar.get(Calendar.WEEK_OF_MONTH);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
            //System.out.println(dayOfWeek);

            if(jobsList.size() > 0)
            {
                inner:
                for (Job job : jobsList)
                {
                    //if weekend dont add orders
                    if(dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY)
                    {
                        dayList.add(new Day(calendar.getTime(), weekNum));
                        break;
                    }
                    else
                    {
                        dayList.add(new Day(calendar.getTime(), job.getJobs(), weekNum));
                        jobsList.remove(job);
                        break;
                    }
                }
            }
            else
            {
                dayList.add(new Day(calendar.getTime(), weekNum));
            }
        }

        for( Day day : dayList )
        {
            System.out.println(day.toString());
        }
    }
}
//                    dayList.add( new Day( calendar.getTime(), new SimpleDateFormat( "MMMM" ).format( calendar.getTime() ),
//                            new SimpleDateFormat( "dd" ).format( calendar.getTime() ), new Order[] { new Order(element[0],new Date()), new Order(element[1],
// new Date()) } ) );


//                        orders = new Order[workerSize];
//
//                        for (int i1 = 0; i1 < tempSize; i1++) {
//                            orders = new Order[tempSize];
//
//                            secondInner:
//                            for (int j = 0; j < tempSize; j++)
//                            {
//                                innerLoop:
//                                for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); )
//                                {
//                                    Map.Entry<Order, Integer> tempMap = order.next();
//                                    Order key = tempMap.getKey();
//
//                                    orders[i1] = key;
//                                    order.remove(); //remove order
//                                    break secondInner;
//
//                                }
//                            }

//orders = new Order[tempSize];
//
//                        secondInner:
//                        for (int j = 0; j < tempSize; j++)
//                        {
//                            innerLoop:
//                            for (Iterator<Map.Entry<Order, Integer>> order = tempWeekOrders.entrySet().iterator(); order.hasNext(); ) {
//                                Map.Entry<Order, Integer> tempMap = order.next();
//                                Order key = tempMap.getKey();
//
//                                orders[j] = key;
//                                order.remove(); //remove order
//                                break secondInner;
//
//                            }
//                        }
