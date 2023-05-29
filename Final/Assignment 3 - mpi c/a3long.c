#include<mpi.h>
#include<stdio.h>
#include<stdlib.h>
#include<unistd.h>
 
//size of array
#define n 10
 
int a[]={3,9,7,10,8,2,1,4,6,5};
 
//Temporary array for slave process
int a2[1000];
 
int main(int argc,char* argv[]){
 
 int pid,np,elements_per_process,n_elements_received;
 //np->no. of processes
 //pid->process id
 
 MPI_Status status;
 
//Creation of parallel processes
MPI_Init(&argc,&argv);
 
// find out process ID,
// and how many processes were started
MPI_Comm_rank(MPI_COMM_WORLD, &pid);
MPI_Comm_size(MPI_COMM_WORLD, &np);
// master process
if (pid == 0) {
int index, i;
printf("Number of processes: %d\n", np);
elements_per_process = n / np;
// check if more than 1 processes are running
if (np>1) {
// distributes the portion of array
// to child processes to calculate
// their partial sums
for (i = 1; i<np - 1; i++) {
index = i * elements_per_process;
MPI_Send(&elements_per_process,
1, MPI_INT, i, 0,
MPI_COMM_WORLD);
 
MPI_Send(&a[index],
 
elements_per_process,
MPI_INT, i, 0,
MPI_COMM_WORLD);
 
}
// last process adds remaining elements
index = i * elements_per_process;
int elements_left = n - index;
MPI_Send(&elements_left,
1, MPI_INT,
i, 0,
MPI_COMM_WORLD);
 
MPI_Send(&a[index],
elements_left,
MPI_INT, i, 0,
MPI_COMM_WORLD);
 
}
// master process add its own sub array
int sum = 0;
for (i = 0; i<elements_per_process; i++) {
sum += a[i];
}
printf("Sum received by root process : %d \n",sum);
// collects partial sums from other processes
int tmp;
for (i = 1; i<np; i++) {
MPI_Recv(&tmp, 1, MPI_INT,
MPI_ANY_SOURCE, 0,
MPI_COMM_WORLD,
&status);
int sender = status.MPI_SOURCE;
printf("Sum received by process : %d is %d\n",sender , tmp);
sum += tmp;
}
// prints the final sum of array
printf("Sum of array is : %d\n", sum);
}
// slave processes
else {
MPI_Recv(&n_elements_received,
1, MPI_INT, 0, 0,
MPI_COMM_WORLD,
&status);
 
// stores the received array segment
// in local array a2
MPI_Recv(&a2, n_elements_received,
 
MPI_INT, 0, 0,
MPI_COMM_WORLD,
&status);
// calculates its partial sum
int partial_sum = 0;
for (int i = 0; i<n_elements_received; i++)
partial_sum += a2[i];
// sends the partial sum to the root process
MPI_Send(&partial_sum, 1, MPI_INT,
0, 0, MPI_COMM_WORLD);
 
}
// cleans up all MPI state before exit of process
MPI_Finalize();
return 0;
}


/
//The mpi.h file contains the definitions and declarations necessary for compiling an MPIprogram.
//MPI_Init initializes the execution environment for MPI.
//To get the different processes to interact, the concept of communicators is needed.
//“MPI_COMM_WORLD” communicator contains all the concurrent processes making up an MPI program./
//The size of a communicator is the number of processes that makes up the particular communicator. The function "MPI_Comm_size” required to return the number of processes
 //Every process within the communicator has a unique ID referred to as its “rank”.The MPI command to determine the process rank is: int MPI_Comm_rank (MPI_Comm comm, int _rank).
//The sendfunction is used by the source process to define the data and establish the connectionof the message. 
//The send construct has the following syntax: int MPI_Send (void _message, int count, MPI_Datatype datatype,int dest, int tag, MPI_Comm comm)/
//The first three operands establish the data to be transferred between the source and destination processes. 
//The first argument points to the message content itself, which may be a simple scalar or a group of data. The message data content is described by the next two arguments. 
//The second operand specifies the number of data elements of which the message is composed.
 //The third operand indicates the data type of the elements that make up the message
//The receive command (MPI_Recv) describes both the data to be transferred and theconnection to be established. The MPI_Recv construct is structured as follows:
//MPI_Finalizecleans up all the extraneous mess that was first put into place by MPI_Init
//MPJ Express is an open source Java message passing library that allows application developers to write and execute parallel applications for multicore processors and compute clusters / clouds. The multicore configuration is meant for users who plan to write and execute parallel Java applications using MPJ Express on their desktops or laptops which contains shared memory and multicore processors. In this configuration, users can write their message passing parallel application using MPJ Express and it will be ported automatically on multicore processors.


