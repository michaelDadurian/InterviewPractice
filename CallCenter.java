/*Three levels of employees: fresher, technical lead, product manager.
	-multiple employees, only one TL or PM
	-incoming call is given to a free fresher
	-if fresher is busy, escalate call to TL, if TL is busy escale to PM
	-implement getCallHandler()*/
	

public class CallHandler{
	static final int LEVELS = 3; //3 levels of employees
	static final int NUM_FRESHERS = 5; //5 freshers, 7 employees total
	ArrayList<Employee>[] employeeLevels = new ArrayList[LEVELS];
	Queue<Call>[] callQueues = new LinkedList[LEVELS];
	
	public CallHandler(){}
	
	Employee getCallHandler(Call call){
		for (int level = call.rank; level < LEVELS - 1; level++){
			ArrayList<Employee> employeeLevel = employeeLevels[level];
			for (Employee emp: employeeLevel){
				if (emp.free)
					return emp;
			}
		}
		return null;
	}
	
	void dispatchCall(Call call){
		Employee emp = getCallHandler(call);
		if (emp != null)
			emp.receiveCall(call);
		else{
			//place call into queue according to rank
			callQueues[call.rank].add(call);
		}
	}
	
	//find call that matches employee rank
	void getNextCall(Employee emp){
		for (Call call: callQueues){
			if (call.rank == emp.rank){
				dispatchCall(call);
				break;
			}
				
		}
		
	}
	
}

class Call{
	int rank = 0; //minimum rank of employee that can handle the call (fresher)
	public void reply(String message){
		System.out.println(message);
	}
	public void disconnect(){
		return;
	}
}

//employee has a rank, free status
//function to escalate a call
class Employee{
	int rank; //0 = fresher, 1 = TL, 2 = PM
	boolean free;
	CallHandler callHandler;
	
	public Employee(int rank){
		this.rank = rank;
	}
	
	void receiveCall(Call call){}
	void callHandled(Call call){}
	//if employee is occupied, escalate call to next rank
	void cannotHandle(Call call){
		call.rank = rank + 1;
		callHandler.dispatchCall(call);
		free = true;
		callHandler.getNextCall(this);
		
	}
}

class Fresher extends Employee{
	public Fresher(){
		super(0);
	}
}

class TechLead extends Employee {
	public TechLead(){
		super(1);
	}
}

class ProductManager extends Employee{
	public ProductManager(){
		super(2);
	}
}