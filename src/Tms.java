package com.wjava.ch15;
 
import java.util.Scanner;



 public class Tms {
        private Teacher[] teas;
        private int index;		
 
 	public Tms(){
 		this.teas = new Teacher[3];
 		this.index = 0;
 }
 	


 public void save(Teacher tea){
 	
 	if(index >= teas.length){
 		Teacher[] demo = new Teacher[teas.length+4];
 		System.arraycopy(teas,0,demo,0,index);
 		teas = demo;
 }
	teas[index++] = tea;
}
 	


public Teacher[] findAll(){
 	Teacher[] demo = new Teacher[index];
 	System.arraycopy(teas,0,demo,0,index);
 	return demo;
 }
 


public Teacher findById(long id){
 	
	int num = findIndexById(id);
 	
 	return num==-1?null:teas[num];
 }
 


 public int findIndexById(long id){
 	int num = -1;
 	for(int i=0;i<index;i++){
 		if(teas[i].getId() == id){
 			num = i;
 			break;
 		}
 	}
 	return num;
 }
 
 
 


public void deleteById(long id){
 	int num = findIndexById(id);
 	for(int i=num;i<index-1;i++){
 		teas[i] = teas[i+1];
 	}
 	teas[--index] = null;
 }
 
 public void update(Teacher newTea){
	 for(int i=0;i<index;i++){
			if(teas[i].getId() == newTea.getId()){
				teas[i].setName(newTea.getName());
				teas[i].setAge(newTea.getAge());
			}
		}
 	
 }
 
 


 public void menu(){
 	System.out.println("***********��ʦ��Ϣ����ϵͳ***********");
 	System.out.println("*1. ��ѯ���н�ʦ��Ϣ");
 	System.out.println("*2. ¼���ʦ��Ϣ");
 	System.out.println("*3. ɾ����ʦ��Ϣ");
 	System.out.println("*4. �鿴��ʦ��Ϣ");
 	System.out.println("*5. ���Ľ�ʦ��Ϣ");
 	System.out.println("*help. ����");
 	System.out.println("*exit. �˳�");
 	System.out.println("**************************************");
 }
 
 public static void main(String[] args){
 	Tms tms= new Tms();	
 	Scanner sc = new Scanner(System.in);
 	tms.menu();
 	while(true){
 		System.out.print("�����빦�ܱ�ţ�");
 		String option = sc.nextLine();
 	switch(option){
 			case "1":{
 				System.out.println("���������н�ʦ����Ϣ��");
 				
 				Teacher[] arr = tms.findAll();
 				
 				for(Teacher tea : arr){
 					System.out.println(tea);
 				}
 				System.out.println("�ܼ� "+tms.index+"��");
 				break;
 			}
 			case "2":{//¼���ʦ��Ϣ
 				while(true){
 					System.out.println("�������ʦ��Ϣ��id#name#age���������롾break���������˵�");
 					String teaStr = sc.nextLine();
 					if(teaStr.equals("break")){
 						break;
 					}
 					String[] teaArr = teaStr.split("#");
					//���û���������д���
 					long id = Long.parseLong(teaArr[0]);
 					String name = teaArr[0];
 					int age = Integer.parseInt(teaArr[2]);
 					//��װ����
 					Teacher tea = new Teacher(id,name,age);
					//���ñ��淽��
 					tms.save(tea);
 					System.out.println("¼��ɹ���");
 						
 				}
 				break;
			}
 			case "3":{//ɾ����ʦ��Ϣ
 				while(true){
 					System.out.println("������Ҫɾ����ʦ�ġ�id���������롾break��������Ŀ¼");
 					String idStr = sc.nextLine();
 					if(idStr.equals("break")){
 						break;
 					}
 					//���ַ���idת��Ϊ������
 					long id = Long.parseLong(idStr);
 					Teacher tea = tms.findById(id);
 					if(tea == null){
 						System.out.println("�ý�ʦ�����ڣ�");
 						continue;
 					}
 					tms.deleteById(id);
 					System.out.println("ɾ���ɹ���");
 				}
 
 				break;
 		}
 			case "4":{//�鿴��ʦ��Ϣ
 				while(true){
 					System.out.println("������Ҫ���ҽ�ʦ�ġ�id���������롾break��������Ŀ¼");
 					String idStr = sc.nextLine();
 					if(idStr.equals("break")){
 						break;
 					}
 					//���ַ���idת��Ϊ������
 					long id = Long.parseLong(idStr);
 					Teacher tea = tms.findById(id);
 					if(tea == null){
 						System.out.println("�ý�ʦ�����ڣ�");
 						continue;
 					}
 					System.out.println(tea);
 				}
 				break;
 			}
 			case "5":{
				while(true){
						System.out.println("������Ҫ�޸Ľ�ʦ�ġ�id���������롾break��������Ŀ¼");
						String idStr = sc.nextLine();
						if(idStr.equals("break")){
							break;
						}
						//���ַ���idת��Ϊ������
						long id = Long.parseLong(idStr);
						Teacher tea = tms.findById(id);
						if(tea == null){
							System.out.println("��Ҫ�޸ĵĽ�ʦ��Ϣ�����ڣ�");
							continue;
						}

						System.out.println("��Ҫ�޸ĵĽ�ʦ��ϢΪ��"+tea);
						System.out.println("������ý�ʦ������Ϣ��name#gender#age��");
						String teaStr = sc.nextLine();
						String[] teaArr = teaStr.split("#");
						String name = teaArr[0];
						int age = Integer.parseInt(teaArr[2]);
						Teacher newTea = new Teacher(id,name,age);
						tms.update(newTea);
						System.out.println("�޸ĳɹ�");
					}
 				break;
 			}
 			case "exit":{
 				System.out.println("bye bye!��ӭ�ٴ�ʹ�ã�");
				System.exit(0);
 			}
 			case "help":{
 				tms.menu();
 				break;
 			}
 			default:
 				System.out.println("��������");
 		}
 	}
 }
} 