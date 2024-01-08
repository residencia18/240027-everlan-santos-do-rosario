import { Pipe, PipeTransform } from '@angular/core';

@Pipe({
  name: 'demoPipe',
  standalone: true
})
export class DemoPipePipe implements PipeTransform {

  transform(value: string, limit: number = 1): string {
    return value.toUpperCase().slice(0, limit);
  }

}
