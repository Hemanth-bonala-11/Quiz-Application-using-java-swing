
package quiz.application;
/**
 *
 * @author heman
 */
public class ArrayOperations {

    public void deleteElement(int[] arr,int value){
        for(int i=0;i<arr.length;i++){
            if(arr[i]==value){
                for(int j=i;j<(arr.length-1);j++){
                    arr[j]=arr[j+1];
                }
                break;
            }
        }
    }
}
