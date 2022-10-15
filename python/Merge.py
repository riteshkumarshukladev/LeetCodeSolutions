# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class Solution:
    def mergeKLists(self, w: List[Optional[ListNode]]) -> Optional[ListNode]:
        r=ListNode()
        h=[]
        heapify(h)
        for i in range(len(w)):
            if w[i]:
                heappush(h,(w[i].val,i))
                w[i]=w[i].next
        curr=r
        while h:
            u,v=heappop(h)
            if w[v]:
                heappush(h,(w[v].val,v))
                w[v]=w[v].next
            curr.next=ListNode(u)
            curr=curr.next
        return r.next