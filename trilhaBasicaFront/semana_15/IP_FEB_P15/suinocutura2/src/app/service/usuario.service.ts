import { Injectable } from '@angular/core';
import { Firestore, CollectionReference, collection } from '@angular/fire/firestore';
import {addDoc, doc, getDocs, updateDoc, deleteDoc, getDoc } from 'firebase/firestore';
import { Post } from '../model/post.model';

@Injectable({
  providedIn: 'root'
})
export class UsuarioService {

  constructor(private firestore: Firestore) { }

  postCollection = collection(this.firestore, 'posts') as CollectionReference<Post>;
  
  async addPost(post: Post) {
    const docRef = await addDoc(this.postCollection, post);

    return docRef;
  }

  getPost = async (postId: string) => {
    const docRef = doc(this.postCollection, postId);
    const docSnap = await getDoc(docRef);
  }
  
  async deletePost(postId: string) {
    const docRef = doc(this.firestore, 'posts', postId);
    await deleteDoc(docRef);
  }
}
