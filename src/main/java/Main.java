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

    static class Foo
    {
        private int orderId;
        private int week;
        private String date;
    }

    public static void createCal()
    {
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Calendar cal = Calendar.getInstance();
        cal.set( Calendar.DAY_OF_MONTH, 1 );

        int numOfOrders = 12;
        int weekOneOrders = 2;
        int weekTwoOrders = 6;
        int weekThreeOrders = 4;

        List<Order> orderList = new ArrayList<>();

        //list of orders with id and latest start date
        for (int i = 0; i < numOfOrders; i++)
        {
            orderList.add(new Order(i, cal.getTime()));
            cal.add( Calendar.DATE, 2 );
        }

        //orders and week they belong to
        Map<Order,Integer> orderMap = new LinkedHashMap<>();
        orderMap.put( orderList.get(0), 1 );
        orderMap.put( orderList.get(1), 1 );

        orderMap.put( orderList.get(2), 2 );
        orderMap.put( orderList.get(3), 2 );
        orderMap.put( orderList.get(4), 2 );
        orderMap.put( orderList.get(5), 2 );
        orderMap.put( orderList.get(6), 2 );
        orderMap.put( orderList.get(7), 2 );

        orderMap.put( orderList.get(8), 3 );
        orderMap.put( orderList.get(9), 3 );
        orderMap.put( orderList.get(10), 3 );
        orderMap.put( orderList.get(11), 3 );

        List<Day> dayList = new ArrayList<>();

        List<Worker> workerList = new ArrayList<>();
        workerList.add(new Worker(0,"Permanent",false));
        workerList.add(new Worker(1,"Permanent",false));
//        workerList.add(new Worker(2,"Contract",false));
//        workerList.add(new Worker(3,"Contract",false));
//        workerList.add(new Worker(4,"Contract",false));

        //create calender for the month
        Calendar calendar = Calendar.getInstance();
        int monthMaxDays = calendar.getActualMaximum( Calendar.DAY_OF_MONTH );

        List<List<Day>> scheduleList = new ArrayList<>();
        List<Day> week1 = new ArrayList<>();
        List<Day> week2 = new ArrayList<>();
        List<Day> week3 = new ArrayList<>();
        List<Day> week4 = new ArrayList<>();
        List<Day> restOfWeek = new ArrayList<>();


        for( int i = 1; i <= monthMaxDays; i++ )
        {
            calendar.set(Calendar.DAY_OF_MONTH, i);
            int weekNum = calendar.get(Calendar.WEEK_OF_MONTH);
            int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);

            if( weekNum == 1 )
            {
                week1.add(new Day(calendar.getTime(), 1 ));
            }
            else if( weekNum == 2 )
            {
                week2.add(new Day(calendar.getTime(), 2 ));
            }
            else if( weekNum == 3 )
            {
                week3.add(new Day(calendar.getTime(), 3 ));
            }
            else if( weekNum == 4 )
            {
                week4.add(new Day(calendar.getTime(), 4 ));
            }
            else
            {
                restOfWeek.add(new Day(calendar.getTime(), 5 ));
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
                System.out.println(day.toString());
            }
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
//                            new SimpleDateFormat( "dd" ).format( calendar.getTime() ), new Order[] { new Order(element[0],new Date()), new Order(element[1],new Date()) } ) );