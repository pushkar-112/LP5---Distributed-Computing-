import time


def average_time(node_curr_time,server_time):
    time_diff=0

    for i in node_curr_time:
        time_diff+=(i-server_time)

    avg_time=time_diff/len(node_curr_time)

    server_time_new = server_time+avg_time
    print("\nUpdated Server time ",server_time_new)
    return server_time_new


def berkeley(node_curr_time,server_time):
    avg_time=average_time(node_curr_time,server_time)
    updated_time=[]
    for i in range(len(node_curr_time)):
        updated_time.append(avg_time)
    
    return updated_time

if __name__ == "__main__":

    node_count=int(input("Enter no of processes:"))

    node_curr_time=[]

    for i in range(node_count):
        print("Enter time of node ",i+1," ih hr format")
        x=int(input())
        node_curr_time.append(x)

    print("\nEnter server time:")
    server_time=int(input())

    updated_time=berkeley(node_curr_time,server_time)

    for i in range(node_count):
        print("The updated time for node ",i," is ",updated_time[i])
