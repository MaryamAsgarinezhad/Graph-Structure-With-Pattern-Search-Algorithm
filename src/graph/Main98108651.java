package graph;

import java.util.Comparator;
import java.util.Arrays;
import java.util.Scanner;

public class Main98108651 {
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
        String str1 = input.next();
        String str2 = input.next();
        
        vlist gr1=new vlist();
        vlist gr2=new vlist();
        String array1[]=str1.split("\\)");

        for(int i=0;i <= array1.length-1;i++){
        	array1[i]=array1[i].substring(1);
        	}
        
        String s[]=new String[3];
        for(int i=0;i<=array1.length-1;i++){
        	s=array1[i].split("\\,");
        	int[] s1=new int[3];
        	s1[0]=Integer.parseInt(s[0]);
        	s1[1]=Integer.parseInt(s[1]);
        	s1[2]=Integer.parseInt(s[2]);
        	if(gr1.exist(s1[0])==null && gr1.exist(s1[1])==null){
        		vertex v=new vertex(s1[0]);
        		vertex v2=new vertex(s1[1]);
        		neighbor n=new neighbor(v2,s1[2]);
        		neighbor n2=new neighbor(v,(180+s1[2])%360);
        		nlist nl=new nlist(n);
        		nlist nl2=new nlist(n2);
        		v.neighbors=nl;
        		v2.neighbors=nl2;
        		gr1.insert(v);
        		gr1.insert(v2);
        	}
        	if(gr1.exist(s1[0])!=null && gr1.exist(s1[1])==null){
        		vertex v2=new vertex(s1[1]);
        		neighbor n2=new neighbor(gr1.exist(s1[0]),(180+s1[2])%360);
        		nlist nl2=new nlist(n2);
        		v2.neighbors=nl2;
        		gr1.insert(v2);
        		neighbor n=new neighbor(v2,s1[2]);
        		gr1.exist(s1[0]).neighbors.insert(n);
        	}
        	
        	if(gr1.exist(s1[0])==null && gr1.exist(s1[1])!=null){
        		vertex v=new vertex(s1[0]);
        		neighbor n=new neighbor(gr1.exist(s1[1]),s1[2]);
        		nlist nl=new nlist(n);
        		v.neighbors=nl;
        		gr1.insert(v);
        		neighbor n2=new neighbor(v,(180+s1[2])%360);
        		gr1.exist(s1[1]).neighbors.insert(n2);
        	}
        	
        	if(gr1.exist(s1[0])!=null && gr1.exist(s1[1])!=null){
        		neighbor n=new neighbor(gr1.exist(s1[1]),s1[2]);
        		gr1.exist(s1[0]).neighbors.insert(n);
        		neighbor n2=new neighbor(gr1.exist(s1[0]),(180+s1[2])%360);
        		gr1.exist(s1[1]).neighbors.insert(n2);
        	}
        }
        
        String array2[]=str2.split("\\)");

        for(int i=0;i <= array2.length-1;i++){
        	array2[i]=array2[i].substring(1);
        	}
        
        String ss[]=new String[3];
        for(int i=0;i<=array2.length-1;i++){
        	ss=array2[i].split("\\,");
        	int[] s1=new int[3];
        	s1[0]=Integer.parseInt(ss[0]);
        	s1[1]=Integer.parseInt(ss[1]);
        	s1[2]=Integer.parseInt(ss[2]);
        	if(gr2.exist(s1[0])==null && gr2.exist(s1[1])==null){
        		vertex v=new vertex(s1[0]);
        		vertex v2=new vertex(s1[1]);
        		neighbor n=new neighbor(v2,s1[2]);
        		neighbor n2=new neighbor(v,(180+s1[2])%360);
        		nlist nl=new nlist(n);
        		nlist nl2=new nlist(n2);
        		v.neighbors=nl;
        		v2.neighbors=nl2;
        		gr2.insert(v);
        		gr2.insert(v2);
        	}
        	if(gr2.exist(s1[0])!=null && gr2.exist(s1[1])==null){
        		vertex v2=new vertex(s1[1]);
        		neighbor n2=new neighbor(gr2.exist(s1[0]),(180+s1[2])%360);
        		nlist nl2=new nlist(n2);
        		v2.neighbors=nl2;
        		gr2.insert(v2);
        		neighbor n=new neighbor(v2,s1[2]);
        		gr2.exist(s1[0]).neighbors.insert(n);
        	}
        	
        	if(gr2.exist(s1[0])==null && gr2.exist(s1[1])!=null){
        		vertex v=new vertex(s1[0]);
        		neighbor n=new neighbor(gr2.exist(s1[1]),s1[2]);
        		nlist nl=new nlist(n);
        		v.neighbors=nl;
        		gr2.insert(v);
        		neighbor n2=new neighbor(v,(180+s1[2])%360);
        		gr2.exist(s1[1]).neighbors.insert(n2);
        	}
        	
        	if(gr2.exist(s1[0])!=null && gr2.exist(s1[1])!=null){
        		neighbor n=new neighbor(gr2.exist(s1[1]),s1[2]);
        		gr2.exist(s1[0]).neighbors.insert(n);
        		neighbor n2=new neighbor(gr2.exist(s1[0]),(180+s1[2])%360);
        		gr2.exist(s1[1]).neighbors.insert(n2);
        	}
        }
        int[][] bestans=new int[gr2.size][2];
        int[] ansq=new int[gr2.size+1];
        int exist=1;
        int found=0;

        int bias;
        
        for(int j=1;j<=gr1.size;j++){
        	for(int k=1;k<=gr2.size;k++){
        		for(bias=0 ;bias<360 ;bias++){

        			gr2.find(k).color=1;
        			vertex[] fixcolor=new vertex[10010];
        			int cntr=0;
        			fixcolor[cntr]=gr2.find(k);
        			cntr++;
        			q q1=new q(gr1.find(j));
        			q q2=new q(gr2.find(k));
        			while(q2.first!=null){
        				vertex b1=q1.delq();
        				vertex b2=q2.delq();
            			ansq[b2.value]=b1.value;
            			
        				neighbor n=b2.neighbors.first;
        				while(n!=null){
        					if(n.element.color==1){
        						int a=(n.degree+bias)%360;
            					vertex v1=b1.neighbors.finddegree(a);
            					if(v1==null){
            						exist=0;
            						break;
            					}
            					else{
            						exist=1;
            						n=n.lower;
            						continue;
            					}
        					}

        					else{
        						int a=(n.degree+bias)%360;
            					vertex v1=b1.neighbors.finddegree(a);
            					if(v1==null){
            						exist=0;
            						break;
            					}
            					else{
            						exist=1;
            						vertex v2=n.element;
            						v2.color=1;
            						fixcolor[cntr]=v2;
            						cntr++;
            						q2.enq(v2);
        							q1.enq(v1);
            						ansq[v2.value]=v1.value;
            						
            					}
            					n=n.lower;
        					}
        				}
        				if(exist==0){
        					fix(fixcolor,cntr);
    						break;
        				}
        			}
        			if(exist==1){
        				int[][] ans=new int[gr2.size][2];
        				for(int i=1; i<=gr2.size ;i++){
        					ans[i-1][0]=ansq[i];
        					ans[i-1][1]=i;
        				}
        				if(found==0){
        					bestans=ans;
        					found=1;
        					fix(fixcolor,cntr);
        					sort(bestans);
        					continue;
        				}
        				sort(ans);
        				bestans=best(bestans,ans);
        				fix(fixcolor,cntr);
        			}
        		}
        		if(found==1){break;}
        		
        	}
        	if(found==1){break;}
        }
        
        if(found==0){
        	System.out.println("NOMATCH");
        }
        else{
        	for(int i=0;i<gr2.size ;i++){
        		System.out.print("(" + bestans[i][0] +"," +bestans[i][1] + ")");
        	}
        }
	}
 public static void sort(int arr[][]){
        Arrays.sort(arr, (a,b) -> Integer.compare(a[0],b[0]));
	 }
 
 public static void fix(vertex arr[], int y){    
		for(int i=0;i<y;i++){
			System.out.println(i);
			arr[i].color=0;
		}
	}
 
 public static int[][] best(int  a[][] ,int b[][]){
	 int l=a.length;
	 for(int i=0; i<l-1;i++){
		 if(a[0][i]<b[0][i]){
			 return a;
		 }
		 if(a[0][i]>b[0][i]){
			 return b;
		 }
	 }
	 
	 for(int i=0; i<l-1;i++){
		 if(a[1][i]<b[1][i]){
			 return a;
		 }
		 if(a[1][i]>b[1][i]){
			 return b;
		 }
	 }
	 return a;
 }
}
class neighbor{     //(199,444,567)(1,2,3)(23,45,667)   (1,20,60)(1,4,45)(20,4,55)
	public vertex element;
	public int degree;
	public neighbor lower;
	
	public neighbor(){
		
	}
	
	public neighbor(vertex v,int degree){
		this.element=v;
		this.degree=degree;
		
	}
}

class vlist{
	public vertex first;
	public vertex last;
	public int size=0;

	public vlist(){
		
	}
	
	public vlist(vertex v){
		this.first=v;
		this.last=v;
		this.size=1;
	}
	public vertex find(int i){
		vertex n=this.first;
		for(int y=1;y<i;y++){
			n=n.next;
		}
		return n;
	}
	public void insert(vertex v){
		if(this.first==null){
			this.first=v;
			this.last=v;
			size++;
		}
		else{
			if(v.value<=this.first.value){
				v.next=this.first;
				this.first=v;
				size++;
			}
			else{
				vertex s=this.first;
				while(s.value<v.value && s!=this.last){
					if(v.value<=s.next.value){
						v.next=s.next;
						s.next=v;
						size++;
						break;
					}
					else{
						s=s.next;
					}
				}
				if(s==this.last){
					s.next=v;
					this.last=v;
					size++;
				}
			}
			
		}
	}
	
	public vertex exist(int i){
		vertex[] t=new vertex[7];
		if(this.first==null){
			return null;
		}
		else{
			vertex s=this.first;
			while(s.value!=i && s!=this.last){
				s=s.next;
			}
			if(s==this.last){
				if(s.value==i){
					return s;
				}
				else{
					return null;
				}
			}
			else{
				if(s.value==i){
					return s;
				}
				else{
					return null;
				}
			}
		}
	}
	
}

class nlist{
	public neighbor first;
	public neighbor last;
	
	public nlist(){
		
	}
	
	public nlist(neighbor v){
		this.first=v;
		this.last=v;
	}
	
	public void insert(neighbor n){
		if(n.element.value<=this.first.element.value){
			n.lower=this.first;
			this.first=n;
		}
		else{
			neighbor s=this.first;
			while(s.element.value<n.element.value && s!=this.last){
				if(n.element.value<=s.lower.element.value){
					n.lower=s.lower;
					s.lower=n;
					break;
				}
				else{
					s=s.lower;
				}
			}
			if(s==this.last){
				s.lower=n;
				this.last=n;
			}
		}
	}
	
	public vertex finddegree(int i){
		neighbor n=this.first;
		while(n!=null){
			if(n.degree==i){
				return n.element;
			}
			n=n.lower;
		}
		return null;
	}
}

class vertex{
	public int value;
	public nlist neighbors;
	public vertex next;
	public vertex qnext;
	public vertex qprev;
	public int color;
	
	
    public vertex(int i){
		this.value=i;
		this.color=0;
	}
}

class q{
	vertex first;
	vertex last;
	int size=0;

	
	public q(){
		
	}
	
	public q(vertex v){
		this.first=v;
		this.last=v;
		this.size++;
	}
	
	public void enq(vertex v){
		if(this.first==null){
			this.first=v;
			this.last=v;
			this.size++;

		}
		v.qnext=this.first;
		this.first.qprev=v;
		this.first=v;
		this.size++;
	}
	
	public vertex delq(){
		if(this.last==this.first){
			vertex ans=this.first;
			this.first=null;
			this.last=null;
			return ans;
		}
		else{
			this.last=this.last.qprev;
			return this.last.qnext;
		}
	}
}