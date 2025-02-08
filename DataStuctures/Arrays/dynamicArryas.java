// A resizable array from Java's ArrayList class in java.util package.
// ✅ Dynamic size, easy insertion/deletion
// 🚫 Slower than arrays for direct access

// ### **Time & Space Complexity of Dynamic Array (ArrayList) in Java**

// #### **1. Time Complexity Analysis**
// | Operation | Time Complexity | Explanation |
// |-----------|---------------|-------------|
// | **Access (`get(index)`)** | **O(1)** | Direct index access like `arr[i]` takes constant time. |
// | **Insert (`add(value)`) at the end** | **O(1) (Amortized)** | Most of the time, adding to the end is fast. But when resizing occurs, it takes **O(n)**. |
// | **Insert (`add(index, value)`) at an arbitrary position** | **O(n)** | Requires shifting elements to make space. |
// | **Delete (`remove(index)`)** | **O(n)** | Elements after the removed index need to be shifted. |
// | **Search (`contains(value)`)** | **O(n)** | Requires scanning the array since it's unsorted. |

// - **Best Case:** O(1) (Appending at the end without resizing)
// - **Worst Case:** O(n) (Inserting at the beginning or middle, causing a shift)

// #### **2. Space Complexity Analysis**
// | Case | Space Complexity | Explanation |
// |------|-----------------|-------------|
// | **Empty ArrayList** | **O(1)** | Takes a small constant space initially. |
// | **ArrayList with `n` elements** | **O(n)** | Stores `n` elements in contiguous memory. |
// | **Resizing (Doubling strategy)** | **O(n)** | When capacity is exceeded, a new array (double the size) is created, copying `n` elements. |

// ### **Resizing Behavior**
// Java's `ArrayList` **doubles** its capacity when it's full.  
// - If capacity is **`k`**, after `n` insertions, it resizes ⬇️  
//   - Copies **old elements (`O(n)`)**  
//   - New size **≈ `2k`**  
//   - Overall, **O(n) amortized complexity** for insertions.

// ---

// ### **Summary**
// - **Access:** O(1)  
// - **Insert (end):** O(1) (amortized), O(n) (worst)  
// - **Insert (middle/beginning):** O(n)  
// - **Remove:** O(n)  
// - **Space Complexity:** O(n)  

// 🔹 **Use `ArrayList` for fast lookups & dynamic storage.**  
// 🔹 **Avoid inserting/deleting in the middle often.**

public clsss dynamicArrays{
    public static void main (String[] args){
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);
        numbers.add(5);

        System.out.println(numbers); // [1, 2, 3, 4, 5]

        numbers.remove(2); // Removing 3
        System.out.println(numbers); // [1, 2, 4, 5]
    }
}